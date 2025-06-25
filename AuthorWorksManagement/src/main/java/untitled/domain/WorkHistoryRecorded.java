package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WorkHistoryRecorded extends AbstractEvent {

    private Long historyId;
    private WorkId workId;
    private HistoryEventType eventType;
    private Date eventAt;
    private Long eventBy;
    private String description;

    public WorkHistoryRecorded(WorkHistory aggregate) {
        super(aggregate);
    }

    public WorkHistoryRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
