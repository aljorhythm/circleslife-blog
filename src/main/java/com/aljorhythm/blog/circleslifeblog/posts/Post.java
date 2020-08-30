package com.aljorhythm.blog.circleslifeblog.posts;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class Post {
    @LastModifiedDate
    public Date lastModifiedDate;
    @Id
    String id;
    @NonNull
    String content;
    @NonNull
    String userId;
}
