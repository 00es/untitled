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
    collectionResourceRel = "announcements",
    path = "announcements"
)
public interface AnnouncementRepository
    extends PagingAndSortingRepository<Announcement, Long> {
    @Query(
        value = "select announcement " +
        "from Announcement announcement " +
        "where(:title is null or announcement.title like %:title%) and (:createdBy is null or announcement.createdBy = :createdBy) and (:createdAt is null or announcement.createdAt = :createdAt) and (:updatedAt is null or announcement.updatedAt = :updatedAt)"
    )
    List<Announcement> announcementList(
        String title,
        Admin createdBy,
        Date createdAt,
        Date updatedAt,
        Pageable pageable
    );

    @Query(
        value = "select announcement " +
        "from Announcement announcement " +
        "where(:announcementId is null or announcement.announcementId = :announcementId)"
    )
    Announcement announcementDetails(Long announcementId);
}
