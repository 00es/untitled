package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SanctionLifted extends AbstractEvent {

    private Long sanctionId;
    private User user;
    private SanctionStatus status;
    private Admin admin;
    private Date liftedAt;
    private Boolean notifiedToUser;
    private Boolean notifiedToAdmin;

    public SanctionLifted(SanctionWithUser aggregate) {
        super(aggregate);
    }

    public SanctionLifted() {
        super();
    }
}
//>>> DDD / Domain Event
