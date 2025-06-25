package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AdminServiceOperationApplication;

@Entity
@Table(name = "Announcement_table")
@Data
//<<< DDD / Aggregate Root
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementId;

    private String title;

    private String content;

    private Admin createdBy;

    private Date createdAt;

    private Admin updatedBy;

    private Date updatedAt;

    public static AnnouncementRepository repository() {
        AnnouncementRepository announcementRepository = AdminServiceOperationApplication.applicationContext.getBean(
            AnnouncementRepository.class
        );
        return announcementRepository;
    }

    //<<< Clean Arch / Port Method
    public void deleteAnnouncement(
        DeleteAnnouncementCommand deleteAnnouncementCommand
    ) {
        //implement business logic here:

        AnnouncementDeleted announcementDeleted = new AnnouncementDeleted(this);
        announcementDeleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void createAnnouncement(
        CreateAnnouncementCommand createAnnouncementCommand
    ) {
        //implement business logic here:

        AnnouncementPosted announcementPosted = new AnnouncementPosted(this);
        announcementPosted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void editAnnouncement(
        EditAnnouncementCommand editAnnouncementCommand
    ) {
        //implement business logic here:

        AnnouncementEdited announcementEdited = new AnnouncementEdited(this);
        announcementEdited.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
