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
@Table(name = "BestsellerWithHistory_table")
@Data
//<<< DDD / Aggregate Root
public class BestsellerWithHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private BestsellerActionType actionType;

    private Date timestamp;

    private Admin admin;

    @Embedded
    private WorkId workId;

    public static BestsellerWithHistoryRepository repository() {
        BestsellerWithHistoryRepository bestsellerWithHistoryRepository = AdminServiceOperationApplication.applicationContext.getBean(
            BestsellerWithHistoryRepository.class
        );
        return bestsellerWithHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void selectBestseller(
        SelectBestsellerCommand selectBestsellerCommand
    ) {
        //implement business logic here:

        BestsellerSelected bestsellerSelected = new BestsellerSelected(this);
        bestsellerSelected.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deselectBestseller(
        DeselectBestsellerCommand deselectBestsellerCommand
    ) {
        //implement business logic here:

        BestsellerDeselected bestsellerDeselected = new BestsellerDeselected(
            this
        );
        bestsellerDeselected.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
