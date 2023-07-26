package users.posts.comments.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.posts.comments.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
