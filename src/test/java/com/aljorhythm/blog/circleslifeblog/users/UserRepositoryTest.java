package com.aljorhythm.blog.circleslifeblog.users;

import com.aljorhythm.blog.circleslifeblog.BaseTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ActiveProfiles("test")
@Import(BaseTestConfiguration.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void johnDoeShouldExist() {
        User user = userRepository.findByName("John Doe").block();
        assertNotNull(user);
    }
}