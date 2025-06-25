package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateWorkCommand {

    private Author author;
    private String title;
    private String content;
    private Boolean copyrightAgreement;
}
