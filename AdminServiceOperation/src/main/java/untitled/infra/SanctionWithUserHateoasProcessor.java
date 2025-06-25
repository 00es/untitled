package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class SanctionWithUserHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SanctionWithUser>> {

    @Override
    public EntityModel<SanctionWithUser> process(
        EntityModel<SanctionWithUser> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "sanctionuser")
                .withRel("anctionuser")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/liftsanction")
                .withRel("liftsanction")
        );

        return model;
    }
}
