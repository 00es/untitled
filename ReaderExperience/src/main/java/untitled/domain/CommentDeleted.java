package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentDeleted extends AbstractEvent {

    private Long commentId;
    private Reader reader;
    private Date deletedAt;
    private CommentStatus status;

    public CommentDeleted(Comment aggregate) {
        super(aggregate);
    }

    public CommentDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
