package com.aljorhythm.blog.circleslifeblog.posts;

import com.aljorhythm.blog.circleslifeblog.BaseTestConfiguration;
import com.aljorhythm.blog.circleslifeblog.users.UsersController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(BaseTestConfiguration.class)
class PostsControllerTest {

    @Autowired
    UsersController controller;
    
    @Test
    void shouldHaveMoreThanOnePost() {}
}