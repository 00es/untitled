package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointChargeRequested extends AbstractEvent {

    private Long pointId;
    private Reader reader;
    private Integer amount;
    private String paymentMethod;

    public PointChargeRequested(Point aggregate) {
        super(aggregate);
    }

    public PointChargeRequested() {
        super();
    }
}
//>>> DDD / Domain Event
