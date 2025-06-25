package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WorkCreated extends AbstractEvent {

    private Long workId;
    private Author author;
    private String title;
    private String content;
    private Boolean copyrightAgreement;
    private PublicationStatus publicationStatus;
    private Date createdAt;

    public WorkCreated(Work aggregate) {
        super(aggregate);
    }

    public WorkCreated() {
        super();
    }
}
//>>> DDD / Domain Event
