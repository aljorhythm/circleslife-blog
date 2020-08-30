package com.aljorhythm.blog.circleslifeblog.users;

import com.aljorhythm.blog.circleslifeblog.posts.Post;
import com.aljorhythm.blog.circleslifeblog.posts.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final PostService postService;

    public UsersController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("{userId}/posts")
    private Flux<Post> getPostsByUserId(@PathVariable String userId){
        Flux<Post> posts = postService.findPostsByUserId(userId);
        return posts;
    }
}
