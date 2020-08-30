package com.aljorhythm.blog.circleslifeblog.users;

import com.aljorhythm.blog.circleslifeblog.BaseTestConfiguration;
import com.aljorhythm.blog.circleslifeblog.posts.Post;
import com.aljorhythm.blog.circleslifeblog.posts.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataMongoTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import(BaseTestConfiguration.class)
class PostRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    void newPostWithNullUserIdShouldFail() {
        assertThrows(NullPointerException.class, () -> {
            postRepository.save(Post.builder().content("some content").build());
        });
    }

    @Test
    void newPostShouldHaveLastModifieddDate() {
        User user = userRepository.findByName("John Doe").block();
        Post beachPost = Post.builder().content("A month ago I went to the beach").userId(user.id).build();
        Post savedPost = postRepository.save(beachPost).block();
        assertNotNull(savedPost.getLastModifiedDate());
    }

    @Test
    void johnDoeShouldBeAbleToWritePosts() {
        User user = userRepository.findByName("John Doe").block();
        Post beachPost = Post.builder().content("A month ago I went to the beach").userId(user.id).build();
        Post hungerPost = Post.builder().content("I am hungry").userId(user.id).build();
        Post[] posts = {beachPost, hungerPost};
        postRepository.saveAll(Arrays.asList(posts)).collectList().block();
        List<Post> actualPosts = postRepository.findAllByUserId(user.id).collectList().block();
        assertThat(actualPosts).usingElementComparatorIgnoringFields("id")
                .contains(posts);
    }
}