package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointsCharged extends AbstractEvent {

    private Long pointId;
    private Reader reader;
    private Integer amount;
    private PointChargeStatus status;
    private Date chargedAt;

    public PointsCharged(Point aggregate) {
        super(aggregate);
    }

    public PointsCharged() {
        super();
    }
}
//>>> DDD / Domain Event
