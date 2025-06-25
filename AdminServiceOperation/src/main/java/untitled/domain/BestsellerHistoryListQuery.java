package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BestsellerHistoryListQuery {

    private WorkId workId;
    private BestsellerActionType actionType;
    private Admin admin;
    private Date timestampFrom;
    private Date timestampTo;
}
