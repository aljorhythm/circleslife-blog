package com.aljorhythm.blog.circleslifeblog.comments;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@Builder
public class Comment {
    @LastModifiedDate
    public Date lastModifiedDate;
    @Id
    String id;
    @NonNull
    String comment;
    @NonNull
    String userId;
    @NonNull
    String postId;
}
