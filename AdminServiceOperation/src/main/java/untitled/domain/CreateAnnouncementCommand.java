package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateAnnouncementCommand {

    private String title;
    private String content;
    private Admin createdBy;
}
