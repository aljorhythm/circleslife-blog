package com.aljorhythm.blog.circleslifeblog.posts;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, String> {

    Flux<Post> findAllByUserId(String userId);

    Mono<Post> findTopByOrderByLastModifiedDateDesc();
}