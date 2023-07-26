package users.posts.comments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.posts.comments.entity.Post;
import users.posts.comments.entity.User;
import users.posts.comments.service.PostService;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts() {
        return postService.getAllPosts();
    }


    @PostMapping()
    public ResponseEntity<String> savePost(@RequestBody User user) {
        return postService.savePost(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
