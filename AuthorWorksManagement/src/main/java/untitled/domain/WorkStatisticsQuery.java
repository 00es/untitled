package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class WorkStatisticsQuery {

    private Long workId;
    private Date periodFrom;
    private Date periodTo;
}
