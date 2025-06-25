package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "works", path = "works")
public interface WorkRepository extends PagingAndSortingRepository<Work, Long> {
    @Query(
        value = "select work " +
        "from Work work " +
        "where(:workId is null or work.workId = :workId) and (:periodFrom is null or work.periodFrom = :periodFrom) and (:periodTo is null or work.periodTo = :periodTo)"
    )
    List<Work> workStatistics(
        Long workId,
        Date periodFrom,
        Date periodTo,
        Pageable pageable
    );

    @Query(
        value = "select work " +
        "from Work work " +
        "where(:author is null or work.author = :author) and (:publicationStatus is null or work.publicationStatus = :publicationStatus) and (:createdAtFrom is null or work.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or work.createdAtTo = :createdAtTo)"
    )
    List<Work> workList(
        Author author,
        PublicationStatus publicationStatus,
        Date createdAtFrom,
        Date createdAtTo,
        Pageable pageable
    );

    @Query(
        value = "select work " +
        "from Work work " +
        "where(:workId is null or work.workId = :workId)"
    )
    Work workDetails(Long workId);
}
