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
// @RequestMapping(value="/works")
@Transactional
public class WorkController {

    @Autowired
    WorkRepository workRepository;

    @RequestMapping(
        value = "/workseditwork",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Work editWork(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody EditWorkCommand editWorkCommand
    ) throws Exception {
        System.out.println("##### /work/editWork  called #####");
        Work work = new Work();
        work.editWork(editWorkCommand);
        workRepository.save(work);
        return work;
    }

    @RequestMapping(
        value = "/works/{id}/deletework",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Work deleteWork(
        @PathVariable(value = "id") Long id,
        @RequestBody DeleteWorkCommand deleteWorkCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /work/deleteWork  called #####");
        Optional<Work> optionalWork = workRepository.findById(id);

        optionalWork.orElseThrow(() -> new Exception("No Entity Found"));
        Work work = optionalWork.get();
        work.deleteWork(deleteWorkCommand);

        workRepository.delete(work);
        return work;
    }

    @RequestMapping(
        value = "/worksrequestpublication",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Work requestPublication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestPublicationCommand requestPublicationCommand
    ) throws Exception {
        System.out.println("##### /work/requestPublication  called #####");
        Work work = new Work();
        work.requestPublication(requestPublicationCommand);
        workRepository.save(work);
        return work;
    }

    @RequestMapping(
        value = "/workscreatework",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Work createWork(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateWorkCommand createWorkCommand
    ) throws Exception {
        System.out.println("##### /work/createWork  called #####");
        Work work = new Work();
        work.createWork(createWorkCommand);
        workRepository.save(work);
        return work;
    }
}
//>>> Clean Arch / Inbound Adaptor
