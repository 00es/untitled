package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "workHistories",
    path = "workHistories"
)
public interface WorkHistoryRepository
    extends PagingAndSortingRepository<WorkHistory, Long> {
    @Query(
        value = "select workHistory " +
        "from WorkHistory workHistory " +
        "where(:historyId is null or workHistory.historyId = :historyId)"
    )
    WorkHistory workHistoryDetails(Long historyId);

    @Query(
        value = "select workHistory " +
        "from WorkHistory workHistory " +
        "where(:workId is null or workHistory.workId = :workId) and (:eventType is null or workHistory.eventType = :eventType) and (:eventBy is null or workHistory.eventBy = :eventBy) and (:eventAtFrom is null or workHistory.eventAtFrom = :eventAtFrom) and (:eventAtTo is null or workHistory.eventAtTo = :eventAtTo)"
    )
    List<WorkHistory> workHistoryList(
        WorkId workId,
        HistoryEventType eventType,
        Long eventBy,
        Date eventAtFrom,
        Date eventAtTo,
        Pageable pageable
    );
}
