package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnnouncementEdited extends AbstractEvent {

    private Long announcementId;
    private String title;
    private String content;
    private Admin updatedBy;
    private Date updatedAt;

    public AnnouncementEdited(Announcement aggregate) {
        super(aggregate);
    }

    public AnnouncementEdited() {
        super();
    }
}
//>>> DDD / Domain Event
