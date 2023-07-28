package users.posts.comments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.posts.comments.entity.Comment;
import users.posts.comments.service.CommentService;

import javax.management.relation.InvalidRelationIdException;

@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    public ResponseEntity<String> saveComment(@RequestBody Comment comment) {
        String message = commentService.saveComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

}
