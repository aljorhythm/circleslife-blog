package com.aljorhythm.blog.circleslifeblog;

import com.aljorhythm.blog.circleslifeblog.users.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
@Slf4j
public class BaseTestConfiguration {
    @Bean
    CommandLineRunner initTestData(MongoOperations operations) {
        return args -> {
            operations.dropCollection(User.class);
            operations.insert(User.builder().name("John Doe").build());
        };
    }
}
