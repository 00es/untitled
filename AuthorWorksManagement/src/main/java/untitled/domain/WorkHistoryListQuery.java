package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class WorkHistoryListQuery {

    private WorkId workId;
    private HistoryEventType eventType;
    private Long eventBy;
    private Date eventAtFrom;
    private Date eventAtTo;
}
