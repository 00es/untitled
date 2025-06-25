package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class BestsellerWithHistoryHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<BestsellerWithHistory>> {

    @Override
    public EntityModel<BestsellerWithHistory> process(
        EntityModel<BestsellerWithHistory> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "selectbestseller"
                )
                .withRel("electbestseller")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "deselectbestseller"
                )
                .withRel("eselectbestseller")
        );

        return model;
    }
}
