package com.aljorhythm.blog.circleslifeblog;

import com.aljorhythm.blog.circleslifeblog.posts.Post;
import com.aljorhythm.blog.circleslifeblog.users.User;
import com.aljorhythm.blog.circleslifeblog.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Slf4j
class StoriesTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    UserRepository userRepository;

    /**
     * User adds a few posts.
     */
    @Test
    public void testStory() {
        User johnDoe = userRepository.findByName("John Doe").block();
        assertEquals("John Doe", johnDoe.getName());
        assertNotNull(johnDoe.getId());

        // no posts yet
        String uri = String.format("/user/%s/posts", johnDoe.getId());
        log.info("URI: " + uri);
        Flux<Post> result = webTestClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Post.class)
                .getResponseBody();
        StepVerifier.create(result).expectNextCount(0).thenCancel().verify();

        // create post
        result = webTestClient.post()
                .uri(String.format("/posts/", johnDoe.getId()))
                .bodyValue(Post.builder().content("This is a new post").userId(johnDoe.getId()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Post.class)
                .getResponseBody();
    }
}