package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class MyCommentListQuery {

    private Reader reader;
    private CommentStatus status;
}
