package com.start.traffic.service;

import com.start.traffic.domain.Post;
import com.start.traffic.dto.PostDto;
import com.start.traffic.repository.MemberRepository;
import com.start.traffic.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Long save(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }


    public Page<PostDto> findByTitleLikePageList(String title, Pageable pageable) {
        return postRepository.findByTitleContains(title, pageable).map(post -> new PostDto(post.getId(), post.getSentence(), post.getTitle(), post.getDate(), post.getMemberIdFk()));
    }

    @Transactional(readOnly = true)
    public Page<Post> pageList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

}
