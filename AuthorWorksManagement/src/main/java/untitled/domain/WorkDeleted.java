package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WorkDeleted extends AbstractEvent {

    private Long workId;
    private Date deletedAt;

    public WorkDeleted(Work aggregate) {
        super(aggregate);
    }

    public WorkDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
