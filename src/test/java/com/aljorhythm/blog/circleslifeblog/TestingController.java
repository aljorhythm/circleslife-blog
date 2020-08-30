package com.aljorhythm.blog.circleslifeblog;

import com.aljorhythm.blog.circleslifeblog.users.User;
import com.aljorhythm.blog.circleslifeblog.users.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Profile("test")
@RequestMapping("/testing")
@RestController
public class TestingController {

    private final UserRepository userRepository;

    public TestingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/johnDoe")
    public Mono<User> getJohnDoeUserId() {
        return userRepository.findByName("John Doe");
    }
}
