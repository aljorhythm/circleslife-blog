package com.aljorhythm.blog.circleslifeblog.posts;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Mono<Post> addPost(Post post, String userId) throws PostServiceException {
        if (userId == null || !userId.equals(post.getUserId())) {
            throw new PostServiceException(PostServiceException.POST_NOT_MADE_BY_USER);
        }
        return postRepository.save(post);
    }

    public Flux<Post> findPostsByUserId(String userId) {
        return postRepository.findAllByUserId(userId);
    }
}
