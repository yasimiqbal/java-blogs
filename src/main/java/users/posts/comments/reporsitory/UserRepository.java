package users.posts.comments.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.posts.comments.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
