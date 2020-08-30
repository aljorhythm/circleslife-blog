package com.aljorhythm.blog.circleslifeblog.users;

import com.aljorhythm.blog.circleslifeblog.BaseTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@Import(BaseTestConfiguration.class)
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void johnDoeShouldExist() {
         User user = userRepository.findByName("John Doe").block();
         assertNotNull(user);
    }
}