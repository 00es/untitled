package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AuthorWorksManagementApplication;

@Entity
@Table(name = "Work_table")
@Data
//<<< DDD / Aggregate Root
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workId;

    private Author author;

    private String title;

    private String content;

    private Boolean copyrightAgreement;

    private PublicationStatus publicationStatus;

    private Date createdAt;

    private Date updatedAt;

    public static WorkRepository repository() {
        WorkRepository workRepository = AuthorWorksManagementApplication.applicationContext.getBean(
            WorkRepository.class
        );
        return workRepository;
    }

    //<<< Clean Arch / Port Method
    public void editWork(EditWorkCommand editWorkCommand) {
        //implement business logic here:

        WorkEdited workEdited = new WorkEdited(this);
        workEdited.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deleteWork(DeleteWorkCommand deleteWorkCommand) {
        //implement business logic here:

        WorkDeleted workDeleted = new WorkDeleted(this);
        workDeleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void requestPublication(
        RequestPublicationCommand requestPublicationCommand
    ) {
        //implement business logic here:

        PublicationRequested publicationRequested = new PublicationRequested(
            this
        );
        publicationRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void createWork(CreateWorkCommand createWorkCommand) {
        //implement business logic here:

        WorkCreated workCreated = new WorkCreated(this);
        workCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
