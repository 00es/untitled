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
// @RequestMapping(value="/comments")
@Transactional
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(
        value = "/commentsreportcomment",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Comment reportComment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportCommentCommand reportCommentCommand
    ) throws Exception {
        System.out.println("##### /comment/reportComment  called #####");
        Comment comment = new Comment();
        comment.reportComment(reportCommentCommand);
        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(
        value = "/commentseditcomment",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Comment editComment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody EditCommentCommand editCommentCommand
    ) throws Exception {
        System.out.println("##### /comment/editComment  called #####");
        Comment comment = new Comment();
        comment.editComment(editCommentCommand);
        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(
        value = "/commentswritecomment",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Comment writeComment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody WriteCommentCommand writeCommentCommand
    ) throws Exception {
        System.out.println("##### /comment/writeComment  called #####");
        Comment comment = new Comment();
        comment.writeComment(writeCommentCommand);
        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(
        value = "/comments/{id}/deletecomment",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Comment deleteComment(
        @PathVariable(value = "id") Long id,
        @RequestBody DeleteCommentCommand deleteCommentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /comment/deleteComment  called #####");
        Optional<Comment> optionalComment = commentRepository.findById(id);

        optionalComment.orElseThrow(() -> new Exception("No Entity Found"));
        Comment comment = optionalComment.get();
        comment.deleteComment(deleteCommentCommand);

        commentRepository.delete(comment);
        return comment;
    }
}
//>>> Clean Arch / Inbound Adaptor
