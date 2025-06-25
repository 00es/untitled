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
@Table(name = "SanctionWithUser_table")
@Data
//<<< DDD / Aggregate Root
public class SanctionWithUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sanctionId;

    private User user;

    private String reason;

    private Date startDate;

    private Date endDate;

    private SanctionStatus status;

    private Admin admin;

    public static SanctionWithUserRepository repository() {
        SanctionWithUserRepository sanctionWithUserRepository = AdminServiceOperationApplication.applicationContext.getBean(
            SanctionWithUserRepository.class
        );
        return sanctionWithUserRepository;
    }

    //<<< Clean Arch / Port Method
    public void sanctionUser(SanctionUserCommand sanctionUserCommand) {
        //implement business logic here:

        UserSanctioned userSanctioned = new UserSanctioned(this);
        userSanctioned.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void liftSanction(LiftSanctionCommand liftSanctionCommand) {
        //implement business logic here:

        SanctionLifted sanctionLifted = new SanctionLifted(this);
        sanctionLifted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
