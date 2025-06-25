package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class CommentListQuery {

    private WorkId workId;
    private CommentStatus status;
    private Date createdAtFrom;
    private Date createdAtTo;
}
