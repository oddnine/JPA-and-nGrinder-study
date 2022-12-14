package com.start.traffic.repository.post;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
