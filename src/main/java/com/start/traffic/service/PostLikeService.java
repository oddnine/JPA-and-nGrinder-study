package com.start.traffic.service;

import com.start.traffic.domain.PostLike;
import com.start.traffic.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class PostLikeService {
    public final PostLikeRepository postLikeRepository;

    public Long save(PostLike postLike) {
        return postLikeRepository.save(postLike).getId();
    }

    public Long getCount(Long id){
        return postLikeRepository.countById(id);
    }
}
