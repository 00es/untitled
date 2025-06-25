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
// @RequestMapping(value="/sanctionWithUsers")
@Transactional
public class SanctionWithUserController {

    @Autowired
    SanctionWithUserRepository sanctionWithUserRepository;

    @RequestMapping(
        value = "/sanctionWithUserssanctionuser",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public SanctionWithUser sanctionUser(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SanctionUserCommand sanctionUserCommand
    ) throws Exception {
        System.out.println(
            "##### /sanctionWithUser/sanctionUser  called #####"
        );
        SanctionWithUser sanctionWithUser = new SanctionWithUser();
        sanctionWithUser.sanctionUser(sanctionUserCommand);
        sanctionWithUserRepository.save(sanctionWithUser);
        return sanctionWithUser;
    }

    @RequestMapping(
        value = "/sanctionWithUsersliftsanction",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public SanctionWithUser liftSanction(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody LiftSanctionCommand liftSanctionCommand
    ) throws Exception {
        System.out.println(
            "##### /sanctionWithUser/liftSanction  called #####"
        );
        SanctionWithUser sanctionWithUser = new SanctionWithUser();
        sanctionWithUser.liftSanction(liftSanctionCommand);
        sanctionWithUserRepository.save(sanctionWithUser);
        return sanctionWithUser;
    }
}
//>>> Clean Arch / Inbound Adaptor
