package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class WorkCreated extends AbstractEvent {

    private Long workId;
    private Object author;
    private String title;
    private String content;
    private Boolean copyrightAgreement;
    private Object publicationStatus;
    private Date createdAt;
}
