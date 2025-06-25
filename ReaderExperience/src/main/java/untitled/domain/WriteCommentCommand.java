package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class WriteCommentCommand {

    private WorkId workId;
    private Reader reader;
    private String content;
}
