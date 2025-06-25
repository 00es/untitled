package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnnouncementDeleted extends AbstractEvent {

    private Long announcementId;
    private Admin deletedBy;
    private Date deletedAt;

    public AnnouncementDeleted(Announcement aggregate) {
        super(aggregate);
    }

    public AnnouncementDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
