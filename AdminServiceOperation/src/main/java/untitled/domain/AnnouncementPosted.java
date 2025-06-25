package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnnouncementPosted extends AbstractEvent {

    private Long announcementId;
    private String title;
    private String content;
    private Admin createdBy;
    private Date createdAt;

    public AnnouncementPosted(Announcement aggregate) {
        super(aggregate);
    }

    public AnnouncementPosted() {
        super();
    }
}
//>>> DDD / Domain Event
