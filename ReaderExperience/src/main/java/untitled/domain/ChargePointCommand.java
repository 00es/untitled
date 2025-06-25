package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ChargePointCommand {

    private Reader reader;
    private Integer amount;
    private String paymentMethod;
}
