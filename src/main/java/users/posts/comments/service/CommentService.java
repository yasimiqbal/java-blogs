package users.posts.comments.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import users.posts.comments.entity.Comment;
import users.posts.comments.reporsitory.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public String saveComment(Comment comment) {
        return "success";
    }
}
