package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class WorkEdited extends AbstractEvent {

    private Long workId;
    private String title;
    private String content;
    private Date updatedAt;
}
