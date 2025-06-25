package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestPublicationCommand {

    private Long workId;
    private Boolean copyrightAgreement;
}
