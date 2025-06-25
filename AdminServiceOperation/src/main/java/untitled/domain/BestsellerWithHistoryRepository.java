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
    collectionResourceRel = "bestsellerWithHistories",
    path = "bestsellerWithHistories"
)
public interface BestsellerWithHistoryRepository
    extends PagingAndSortingRepository<BestsellerWithHistory, Long> {
    @Query(
        value = "select bestsellerWithHistory " +
        "from BestsellerWithHistory bestsellerWithHistory " +
        "where(:historyId is null or bestsellerWithHistory.historyId = :historyId)"
    )
    BestsellerWithHistory bestsellerHistoryDetails(Long historyId);

    @Query(
        value = "select bestsellerWithHistory " +
        "from BestsellerWithHistory bestsellerWithHistory " +
        "where(:workId is null or bestsellerWithHistory.workId = :workId) and (:actionType is null or bestsellerWithHistory.actionType = :actionType) and (:admin is null or bestsellerWithHistory.admin = :admin) and (:timestampFrom is null or bestsellerWithHistory.timestampFrom = :timestampFrom) and (:timestampTo is null or bestsellerWithHistory.timestampTo = :timestampTo)"
    )
    List<BestsellerWithHistory> bestsellerHistoryList(
        WorkId workId,
        BestsellerActionType actionType,
        Admin admin,
        Date timestampFrom,
        Date timestampTo,
        Pageable pageable
    );
}
