package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class WorkHistoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<WorkHistory>> {

    @Override
    public EntityModel<WorkHistory> process(EntityModel<WorkHistory> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "recordworkhistory"
                )
                .withRel("ecordworkhistory")
        );

        return model;
    }
}
