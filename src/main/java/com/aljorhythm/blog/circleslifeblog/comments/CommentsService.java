package com.aljorhythm.blog.circleslifeblog.comments;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentsService {

    private final CommentRepository commentRepository;

    public CommentsService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Mono<Comment> addComment(Comment comment, String postId, String userId) throws CommentsServiceException {
        if (comment.getPostId() == null || !comment.getPostId().equals(postId)) {
            throw new CommentsServiceException(CommentsServiceException.COMMENT_NOT_IN_POST);
        }
        if (comment.getUserId() == null || !comment.getUserId().equals(userId)) {
            throw new CommentsServiceException(CommentsServiceException.COMMENT_NOT_MADE_BY_USER);
        } else {
            return commentRepository.save(comment);
        }
    }

    public Flux<Comment> findAllByPostId(String postId) {
        return commentRepository.findAllByPostId(postId);
    }
}
