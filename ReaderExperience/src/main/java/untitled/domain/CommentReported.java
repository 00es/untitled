package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentReported extends AbstractEvent {

    private Long commentId;
    private Reader reader;
    private String reason;
    private Date reportedAt;
    private Integer reportCount;
    private CommentStatus status;

    public CommentReported(Comment aggregate) {
        super(aggregate);
    }

    public CommentReported() {
        super();
    }
}
//>>> DDD / Domain Event
