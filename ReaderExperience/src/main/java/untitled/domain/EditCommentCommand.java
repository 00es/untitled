package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class EditCommentCommand {

    private Long commentId;
    private Reader reader;
    private String content;
}
