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
    collectionResourceRel = "sanctionWithUsers",
    path = "sanctionWithUsers"
)
public interface SanctionWithUserRepository
    extends PagingAndSortingRepository<SanctionWithUser, Long> {
    @Query(
        value = "select sanctionWithUser " +
        "from SanctionWithUser sanctionWithUser " +
        "where(:user is null or sanctionWithUser.user = :user)"
    )
    SanctionWithUser mySanctionStatus(User user);

    @Query(
        value = "select sanctionWithUser " +
        "from SanctionWithUser sanctionWithUser " +
        "where(:sanctionId is null or sanctionWithUser.sanctionId = :sanctionId)"
    )
    SanctionWithUser sanctionDetails(Long sanctionId);

    @Query(
        value = "select sanctionWithUser " +
        "from SanctionWithUser sanctionWithUser " +
        "where(:user is null or sanctionWithUser.user = :user) and (:status is null or sanctionWithUser.status = :status) and (:startDateFrom is null or sanctionWithUser.startDateFrom = :startDateFrom) and (:startDateTo is null or sanctionWithUser.startDateTo = :startDateTo) and (:admin is null or sanctionWithUser.admin = :admin)"
    )
    List<SanctionWithUser> sanctionHistory(
        User user,
        SanctionStatus status,
        Date startDateFrom,
        Date startDateTo,
        Admin admin,
        Pageable pageable
    );
}
