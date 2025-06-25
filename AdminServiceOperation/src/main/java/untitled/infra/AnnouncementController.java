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
// @RequestMapping(value="/announcements")
@Transactional
public class AnnouncementController {

    @Autowired
    AnnouncementRepository announcementRepository;

    @RequestMapping(
        value = "/announcements/{id}/deleteannouncement",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Announcement deleteAnnouncement(
        @PathVariable(value = "id") Long id,
        @RequestBody DeleteAnnouncementCommand deleteAnnouncementCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /announcement/deleteAnnouncement  called #####"
        );
        Optional<Announcement> optionalAnnouncement = announcementRepository.findById(
            id
        );

        optionalAnnouncement.orElseThrow(() -> new Exception("No Entity Found")
        );
        Announcement announcement = optionalAnnouncement.get();
        announcement.deleteAnnouncement(deleteAnnouncementCommand);

        announcementRepository.delete(announcement);
        return announcement;
    }

    @RequestMapping(
        value = "/announcementscreateannouncement",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Announcement createAnnouncement(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateAnnouncementCommand createAnnouncementCommand
    ) throws Exception {
        System.out.println(
            "##### /announcement/createAnnouncement  called #####"
        );
        Announcement announcement = new Announcement();
        announcement.createAnnouncement(createAnnouncementCommand);
        announcementRepository.save(announcement);
        return announcement;
    }

    @RequestMapping(
        value = "/announcementseditannouncement",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Announcement editAnnouncement(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody EditAnnouncementCommand editAnnouncementCommand
    ) throws Exception {
        System.out.println(
            "##### /announcement/editAnnouncement  called #####"
        );
        Announcement announcement = new Announcement();
        announcement.editAnnouncement(editAnnouncementCommand);
        announcementRepository.save(announcement);
        return announcement;
    }
}
//>>> Clean Arch / Inbound Adaptor
