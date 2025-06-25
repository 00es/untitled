package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.ReaderExperienceApplication;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pointId;

    private Reader reader;

    private Integer amount;

    private PointChargeStatus status;

    private Date chargedAt;

    public static PointRepository repository() {
        PointRepository pointRepository = ReaderExperienceApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public void applyPointChargeResult(
        ApplyPointChargeResultCommand applyPointChargeResultCommand
    ) {
        //implement business logic here:

        PaymentFailed paymentFailed = new PaymentFailed(this);
        paymentFailed.publishAfterCommit();
        PointsCharged pointsCharged = new PointsCharged(this);
        pointsCharged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void chargePoint(ChargePointCommand chargePointCommand) {
        //implement business logic here:

        PointChargeRequested pointChargeRequested = new PointChargeRequested(
            this
        );
        pointChargeRequested.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
