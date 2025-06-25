package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SanctionHistoryQuery {

    private User user;
    private SanctionStatus status;
    private Date startDateFrom;
    private Date startDateTo;
    private Admin admin;
}
