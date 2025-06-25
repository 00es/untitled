package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteAnnouncementCommand {

    private Long announcementId;
    private Admin deletedBy;
}
