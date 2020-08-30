package com.aljorhythm.blog.circleslifeblog.comments;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class Comment {
    @Id String id;

    @NonNull
    String comment;

    @NonNull
    String userId;
}
