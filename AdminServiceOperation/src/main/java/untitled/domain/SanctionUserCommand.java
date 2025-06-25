package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SanctionUserCommand {

    private User user;
    private String reason;
    private Date startDate;
    private Date endDate;
    private Admin admin;
}
