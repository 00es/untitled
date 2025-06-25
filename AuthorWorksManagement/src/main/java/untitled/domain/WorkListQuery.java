package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class WorkListQuery {

    private Author author;
    private PublicationStatus publicationStatus;
    private Date createdAtFrom;
    private Date createdAtTo;
}
