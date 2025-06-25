package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserSanctioned extends AbstractEvent {

    private Long sanctionId;
    private User user;
    private String reason;
    private Date startDate;
    private Date endDate;
    private SanctionStatus status;
    private Admin admin;
    private Boolean notifiedToUser;
    private Boolean notifiedToAdmin;
    private Date createdAt;

    public UserSanctioned(SanctionWithUser aggregate) {
        super(aggregate);
    }

    public UserSanctioned() {
        super();
    }
}
//>>> DDD / Domain Event
