package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.ReaderExperienceApplication;

@Entity
@Table(name = "Comment_table")
@Data
//<<< DDD / Aggregate Root
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private Reader reader;

    private String content;

    private CommentStatus status;

    private Date createdAt;

    @Embedded
    private WorkId workId;

    public static CommentRepository repository() {
        CommentRepository commentRepository = ReaderExperienceApplication.applicationContext.getBean(
            CommentRepository.class
        );
        return commentRepository;
    }

    //<<< Clean Arch / Port Method
    public void reportComment(ReportCommentCommand reportCommentCommand) {
        //implement business logic here:

        CommentReported commentReported = new CommentReported(this);
        commentReported.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void editComment(EditCommentCommand editCommentCommand) {
        //implement business logic here:

        CommentEdited commentEdited = new CommentEdited(this);
        commentEdited.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void writeComment(WriteCommentCommand writeCommentCommand) {
        //implement business logic here:

        CommentWritten commentWritten = new CommentWritten(this);
        commentWritten.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deleteComment(DeleteCommentCommand deleteCommentCommand) {
        //implement business logic here:

        CommentDeleted commentDeleted = new CommentDeleted(this);
        commentDeleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
