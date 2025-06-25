package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentEdited extends AbstractEvent {

    private Long commentId;
    private Reader reader;
    private String content;
    private CommentStatus status;
    private Date editedAt;

    public CommentEdited(Comment aggregate) {
        super(aggregate);
    }

    public CommentEdited() {
        super();
    }
}
//>>> DDD / Domain Event
