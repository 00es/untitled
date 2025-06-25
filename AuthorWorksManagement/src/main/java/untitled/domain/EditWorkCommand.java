package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class EditWorkCommand {

    private Long workId;
    private String title;
    private String content;
}
