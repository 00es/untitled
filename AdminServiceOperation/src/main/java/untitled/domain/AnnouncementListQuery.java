package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AnnouncementListQuery {

    private String title;
    private Admin createdBy;
    private Date createdAt;
    private Date updatedAt;
}
