package com.start.traffic.controller.post;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import com.start.traffic.service.PostService;
import com.start.traffic.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/save")
    public String postSaveForm(@ModelAttribute("post") PostForm form) {
        return "post/save";
    }

    @PostMapping("/save")
    public String postSave(@ModelAttribute("post") PostForm form, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member) {
        Post post = Post.builder()
                .title(form.getTitle())
                .sentence(form.getSentence())
                .date(LocalDateTime.now())
                .memberIdFk(member).build();

        postService.save(post);
        return "redirect:/board";
    }


}
