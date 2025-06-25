package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class PublicationRequested extends AbstractEvent {

    private Long workId;
    private Object author;
    private Boolean copyrightAgreement;
    private Object publicationStatus;
    private Date requestedAt;
}
