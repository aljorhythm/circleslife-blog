package com.aljorhythm.blog.circleslifeblog.posts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post {
    @Id String id;
    String content;
}
