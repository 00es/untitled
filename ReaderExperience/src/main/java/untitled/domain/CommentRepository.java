package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository
    extends PagingAndSortingRepository<Comment, Long> {
    @Query(
        value = "select comment " +
        "from Comment comment " +
        "where(:commentId is null or comment.commentId = :commentId)"
    )
    Comment commentDetails(Long commentId);

    @Query(
        value = "select comment " +
        "from Comment comment " +
        "where(:workId is null or comment.workId = :workId) and (:status is null or comment.status = :status) and (:createdAtFrom is null or comment.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or comment.createdAtTo = :createdAtTo)"
    )
    List<Comment> commentList(
        WorkId workId,
        CommentStatus status,
        Date createdAtFrom,
        Date createdAtTo,
        Pageable pageable
    );

    @Query(
        value = "select comment " +
        "from Comment comment " +
        "where(:reader is null or comment.reader = :reader) and (:status is null or comment.status = :status)"
    )
    List<Comment> myCommentList(
        Reader reader,
        CommentStatus status,
        Pageable pageable
    );
}
