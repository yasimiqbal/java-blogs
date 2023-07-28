package users.posts.comments.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import users.posts.comments.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
