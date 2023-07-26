package users.posts.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import users.posts.comments.entity.Post;
import users.posts.comments.entity.User;
import users.posts.comments.reporsitory.PostRepository;
import users.posts.comments.reporsitory.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> savePost(User request) {
        try {
            User user = userRepository.findById(request.getId()).get();
            if (user != null) {
                List<Post> posts = savePostsForUser(user, request.getPosts());
                user.setPosts(posts);
                return new ResponseEntity<>("post created successfully", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("user not found", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("no record inserted", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Post> savePostsForUser(User user, List<Post> posts) {
        List<Post> newPosts = new ArrayList<>();
        for (Post p : posts) {
            Post post = new Post();
            post.setTitle(p.getTitle());
            post.setContent(p.getContent());
            post.setUser(user);
            postRepository.save(post);

            newPosts.add(post);
        }
        return newPosts;
    }

    public ResponseEntity<List<Post>> getAllPosts() {
        try {
            return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Boolean> deletePost(Long id) {
        try {
            postRepository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
