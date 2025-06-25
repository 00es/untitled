package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "points", path = "points")
public interface PointRepository
    extends PagingAndSortingRepository<Point, Long> {
    @Query(
        value = "select point " +
        "from Point point " +
        "where(:reader is null or point.reader = :reader) and (:status is null or point.status = :status) and (:chargedAtFrom is null or point.chargedAtFrom = :chargedAtFrom) and (:chargedAtTo is null or point.chargedAtTo = :chargedAtTo)"
    )
    List<Point> pointHistory(
        Reader reader,
        PointChargeStatus status,
        Date chargedAtFrom,
        Date chargedAtTo,
        Pageable pageable
    );

    @Query(
        value = "select point " +
        "from Point point " +
        "where(:reader is null or point.reader = :reader)"
    )
    Point pointBalance(Reader reader);
}
