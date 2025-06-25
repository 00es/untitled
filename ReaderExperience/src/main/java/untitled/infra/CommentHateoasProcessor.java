package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class CommentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Comment>> {

    @Override
    public EntityModel<Comment> process(EntityModel<Comment> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "reportcomment")
                .withRel("eportcomment")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/editcomment")
                .withRel("editcomment")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "writecomment")
                .withRel("ritecomment")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deletecomment")
                .withRel("deletecomment")
        );

        return model;
    }
}
