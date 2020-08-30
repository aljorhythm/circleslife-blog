package com.aljorhythm.blog.circleslifeblog.users;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class User {
    @Id String id;
    String name;
}
