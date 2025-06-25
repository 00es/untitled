package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteCommentCommand {

    private Long commentId;
    private Reader reader;
}
