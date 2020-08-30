package com.aljorhythm.blog.circleslifeblog.security;

import org.springframework.stereotype.Service;

@Service
public class Authenticator {
    public String authenticate(Token token) {
        return token.getUserId();
    }
}
