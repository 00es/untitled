package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentWritten extends AbstractEvent {

    private Long commentId;
    private WorkId workId;
    private Reader reader;
    private String content;
    private CommentStatus status;
    private Date createdAt;

    public CommentWritten(Comment aggregate) {
        super(aggregate);
    }

    public CommentWritten() {
        super();
    }
}
//>>> DDD / Domain Event
