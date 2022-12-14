package com.start.traffic.repository;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import com.start.traffic.repository.member.MemberRepository;
import com.start.traffic.repository.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PostService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional(readOnly = false)
    public void save() {
        Member member = memberRepository.findByEmail("123").get();

        for (int i = 0; i < 10000; i++) {
            Post post = Post.builder()
                    .title("안녕하세요. " + i)
                    .sentence("혁키혁키. " + i)
                    .date(LocalDateTime.now())
                    .memberIdFk(member)
                    .build();
            postRepository.save(post);
        }
    }

    @Test
    public void findAll() {
        List<Post> all = postRepository.findAll();
        for (Post post : all) {
            System.out.println(post.getTitle());
            System.out.println("\tㄴ" + post.getMemberIdFk().getName());
        }
    }

}

