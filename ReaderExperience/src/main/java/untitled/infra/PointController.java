package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/points")
@Transactional
public class PointController {

    @Autowired
    PointRepository pointRepository;

    @RequestMapping(
        value = "/pointsapplypointchargeresult",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Point applyPointChargeResult(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ApplyPointChargeResultCommand applyPointChargeResultCommand
    ) throws Exception {
        System.out.println("##### /point/applyPointChargeResult  called #####");
        Point point = new Point();
        point.applyPointChargeResult(applyPointChargeResultCommand);
        pointRepository.save(point);
        return point;
    }

    @RequestMapping(
        value = "/pointschargepoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Point chargePoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ChargePointCommand chargePointCommand
    ) throws Exception {
        System.out.println("##### /point/chargePoint  called #####");
        Point point = new Point();
        point.chargePoint(chargePointCommand);
        pointRepository.save(point);
        return point;
    }
}
//>>> Clean Arch / Inbound Adaptor
