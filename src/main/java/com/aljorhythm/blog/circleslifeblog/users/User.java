package com.aljorhythm.blog.circleslifeblog.users;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
public class User {
    @Id
    String id;
    String name;
}
