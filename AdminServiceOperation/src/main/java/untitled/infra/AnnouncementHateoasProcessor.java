package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class AnnouncementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Announcement>> {

    @Override
    public EntityModel<Announcement> process(EntityModel<Announcement> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/deleteannouncement"
                )
                .withRel("deleteannouncement")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createannouncement"
                )
                .withRel("reateannouncement")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/editannouncement"
                )
                .withRel("editannouncement")
        );

        return model;
    }
}
