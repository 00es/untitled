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
@Table(name = "WorkHistory_table")
@Data
//<<< DDD / Aggregate Root
public class WorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private HistoryEventType eventType;

    private Date eventAt;

    private Long eventBy;

    private String description;

    @Embedded
    private WorkId workId;

    public static WorkHistoryRepository repository() {
        WorkHistoryRepository workHistoryRepository = AuthorWorksManagementApplication.applicationContext.getBean(
            WorkHistoryRepository.class
        );
        return workHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void recordWorkHistory(
        RecordWorkHistoryCommand recordWorkHistoryCommand
    ) {
        //implement business logic here:

        WorkHistoryRecorded workHistoryRecorded = new WorkHistoryRecorded(this);
        workHistoryRecorded.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
