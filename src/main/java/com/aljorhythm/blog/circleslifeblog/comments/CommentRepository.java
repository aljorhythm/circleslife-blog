package com.aljorhythm.blog.circleslifeblog.comments;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CommentRepository extends ReactiveCrudRepository<Comment, String> {
    Flux<Comment> findAllByPostId(String postId);
}
