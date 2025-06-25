package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PointHistoryQuery {

    private Reader reader;
    private PointChargeStatus status;
    private Date chargedAtFrom;
    private Date chargedAtTo;
}
