package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WorkEdited extends AbstractEvent {

    private Long workId;
    private String title;
    private String content;
    private Date updatedAt;

    public WorkEdited(Work aggregate) {
        super(aggregate);
    }

    public WorkEdited() {
        super();
    }
}
//>>> DDD / Domain Event
