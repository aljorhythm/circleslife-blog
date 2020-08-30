package com.aljorhythm.blog.circleslifeblog.comments;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
    @Id String id;
    String comment;
}
