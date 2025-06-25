package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BestsellerSelected extends AbstractEvent {

    private Long historyId;
    private WorkId workId;
    private BestsellerActionType actionType;
    private Date timestamp;
    private Admin admin;

    public BestsellerSelected(BestsellerWithHistory aggregate) {
        super(aggregate);
    }

    public BestsellerSelected() {
        super();
    }
}
//>>> DDD / Domain Event
