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
// @RequestMapping(value="/bestsellerWithHistories")
@Transactional
public class BestsellerWithHistoryController {

    @Autowired
    BestsellerWithHistoryRepository bestsellerWithHistoryRepository;

    @RequestMapping(
        value = "/bestsellerWithHistoriesselectbestseller",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public BestsellerWithHistory selectBestseller(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SelectBestsellerCommand selectBestsellerCommand
    ) throws Exception {
        System.out.println(
            "##### /bestsellerWithHistory/selectBestseller  called #####"
        );
        BestsellerWithHistory bestsellerWithHistory = new BestsellerWithHistory();
        bestsellerWithHistory.selectBestseller(selectBestsellerCommand);
        bestsellerWithHistoryRepository.save(bestsellerWithHistory);
        return bestsellerWithHistory;
    }

    @RequestMapping(
        value = "/bestsellerWithHistoriesdeselectbestseller",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public BestsellerWithHistory deselectBestseller(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody DeselectBestsellerCommand deselectBestsellerCommand
    ) throws Exception {
        System.out.println(
            "##### /bestsellerWithHistory/deselectBestseller  called #####"
        );
        BestsellerWithHistory bestsellerWithHistory = new BestsellerWithHistory();
        bestsellerWithHistory.deselectBestseller(deselectBestsellerCommand);
        bestsellerWithHistoryRepository.save(bestsellerWithHistory);
        return bestsellerWithHistory;
    }
}
//>>> Clean Arch / Inbound Adaptor
