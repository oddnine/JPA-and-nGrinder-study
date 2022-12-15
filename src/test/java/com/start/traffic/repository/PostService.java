package com.start.traffic.repository;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
    @Transactional
    public void findAll() {
        List<Post> all = postRepository.findAll();
        for (Post post : all) {
            System.out.println(post.getTitle());
            System.out.println("\tㄴ" + post.getMemberIdFk().getName());
        }
    }

}

