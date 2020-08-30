package com.aljorhythm.blog.circleslifeblog.comments;

import com.aljorhythm.blog.circleslifeblog.BaseTestConfiguration;
import com.aljorhythm.blog.circleslifeblog.posts.Post;
import com.aljorhythm.blog.circleslifeblog.posts.PostRepository;
import com.aljorhythm.blog.circleslifeblog.users.User;
import com.aljorhythm.blog.circleslifeblog.users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import({BaseTestConfiguration.class})
class CommentRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void setUpPosts() {
        User user = userRepository.findByName("John Doe").block();
        Post beachPost = Post.builder().content("A month ago I went to the beach").userId(user.getId()).build();
        Post hungerPost = Post.builder().content("I am hungry").userId(user.getId()).build();
        Post[] posts = {beachPost, hungerPost};
        postRepository.saveAll(Arrays.asList(posts)).collectList().block();
    }

    @Test
    void johnDoeShouldBeAbleToCommentOnHisOwnPost() {
        User john = userRepository.findByName("John Doe").block();
        Post lastPost = postRepository.findTopByOrderByLastModifiedDateDesc().block();
        assertEquals("I am hungry", lastPost.getContent());
        Comment newComment = Comment.builder().comment("This seems like bad news")
                .userId(john.getId()).postId(lastPost.getId()).build();
        Comment anotherComment = Comment.builder().comment("Same thoughts")
                .userId(john.getId()).postId(lastPost.getId()).build();
        Comment[] comments = {newComment, anotherComment};
        List<Comment> actualComments = commentRepository.saveAll(Arrays.asList(comments)).collectList().block();
        assertThat(actualComments).usingElementComparatorIgnoringFields("id")
                .contains(comments);
    }
}