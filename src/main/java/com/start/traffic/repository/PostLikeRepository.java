package com.start.traffic.repository;

import com.start.traffic.domain.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Long countById(Long id);
}
