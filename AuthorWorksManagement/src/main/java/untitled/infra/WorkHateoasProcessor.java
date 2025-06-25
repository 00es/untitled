package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class WorkHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Work>> {

    @Override
    public EntityModel<Work> process(EntityModel<Work> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/editwork")
                .withRel("editwork")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deletework")
                .withRel("deletework")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestpublication"
                )
                .withRel("equestpublication")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "creatework")
                .withRel("reatework")
        );

        return model;
    }
}
