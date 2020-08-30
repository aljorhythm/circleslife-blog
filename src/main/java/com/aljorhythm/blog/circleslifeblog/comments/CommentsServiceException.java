package com.aljorhythm.blog.circleslifeblog.comments;

import lombok.Getter;

@Getter
public class CommentsServiceException extends Throwable {
    public static final String COMMENT_NOT_IN_POST = "COMMENT_NOT_IN_POST";
    public static final String COMMENT_NOT_MADE_BY_USER = "COMMENT_NOT_MADE_BY_USER";

    private final String message;

    public CommentsServiceException(String message){
        this.message = message;
    }
}
