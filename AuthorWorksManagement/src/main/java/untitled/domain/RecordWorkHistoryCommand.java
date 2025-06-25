package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordWorkHistoryCommand {

    private WorkId workId;
    private HistoryEventType eventType;
    private Date eventAt;
    private Long eventBy;
    private String description;
}
