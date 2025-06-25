package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PointHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Point>> {

    @Override
    public EntityModel<Point> process(EntityModel<Point> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/applypointchargeresult"
                )
                .withRel("applypointchargeresult")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "chargepoint")
                .withRel("hargepoint")
        );

        return model;
    }
}
