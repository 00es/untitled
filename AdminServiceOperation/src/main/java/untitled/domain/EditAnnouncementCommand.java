package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class EditAnnouncementCommand {

    private Long announcementId;
    private String title;
    private String content;
    private Admin updatedBy;
}
