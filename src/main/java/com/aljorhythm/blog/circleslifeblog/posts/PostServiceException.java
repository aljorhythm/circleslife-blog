package com.aljorhythm.blog.circleslifeblog.posts;

import lombok.Getter;

@Getter
public class PostServiceException extends Throwable {

    public static final String POST_NOT_MADE_BY_USER = "POST_NOT_MADE_BY_USER";

    private final String message;

    public PostServiceException(String message) {
        this.message = message;
    }
}
