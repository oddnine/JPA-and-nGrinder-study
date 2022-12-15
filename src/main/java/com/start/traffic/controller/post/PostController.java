package com.start.traffic.controller.post;

import com.start.traffic.domain.Comment;
import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import com.start.traffic.service.CommentService;
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
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

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

    @GetMapping
    public String detailPost(@RequestParam("id") long id, Model model) {
        Post post = postService.findById(id);
        List<Comment> comments = commentService.findByPostIdFk(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post/detail";
    }

    @PostMapping
    public String writeComment(@RequestParam("id") long id, @ModelAttribute("comment") CommentForm form, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member) {
        Post post = postService.findById(id);

        Comment comment = Comment.builder()
                .sentence(form.getSentence())
                .date(LocalDateTime.now())
                .postIdFk(post)
                .memberIdFk(member).build();
        commentService.save(comment);

        return "redirect:/post?id=" + id;
    }
}
