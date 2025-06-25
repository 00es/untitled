package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ApplyPointChargeResultCommand {

    private Long pointId;
    private PointChargeStatus status;
    private Date chargedAt;
}
