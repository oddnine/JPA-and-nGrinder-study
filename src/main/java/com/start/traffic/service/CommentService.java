package com.start.traffic.service;

import com.start.traffic.domain.Comment;
import com.start.traffic.domain.Post;
import com.start.traffic.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findByPostIdFk(Post post) {
        return commentRepository.findByPostIdFk(post);
    }
}
