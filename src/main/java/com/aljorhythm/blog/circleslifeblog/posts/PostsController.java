package com.aljorhythm.blog.circleslifeblog.posts;

import com.aljorhythm.blog.circleslifeblog.comments.Comment;
import com.aljorhythm.blog.circleslifeblog.comments.CommentsService;
import com.aljorhythm.blog.circleslifeblog.comments.CommentsServiceException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostService postService;
    private final CommentsService commentsService;

    public PostsController(PostService postService, CommentsService commentsService) {
        this.postService = postService;
        this.commentsService = commentsService;
    }

    @PostMapping("/{postId}/comment/")
    private Mono<Comment> getEmployeeById(@PathVariable String postId, @RequestBody Comment comment) throws CommentsServiceException {
        String userId = null;
        return commentsService.addComment(comment, postId, userId);
    }

    @PostMapping("/")
    private Mono<Post> addPost(@RequestBody Post post) throws PostServiceException {
        String userId = null;
        return postService.addPost(post, userId);
    }

    @GetMapping("/{postId}/comments")
    private Flux<Comment> getPostComments(@PathVariable String postId) {
        return commentsService.findAllByPostId(postId);
    }

}
