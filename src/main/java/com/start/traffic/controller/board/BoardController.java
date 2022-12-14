package com.start.traffic.controller.board;

import com.start.traffic.controller.post.PostForm;
import com.start.traffic.domain.Post;
import com.start.traffic.dto.PostDto;
import com.start.traffic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final PostService postService;

    @GetMapping
    public String postList(@ModelAttribute("post") PostForm form, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            form.getTitle().isEmpty();
        } catch (Exception e) {
            form.setTitle("");
        }

        Page<PostDto> posts = postService.findByTitleLikePageList(form.getTitle(), pageable);

        int nowPage = posts.getPageable().getPageNumber() + 1;
        model.addAttribute("posts", posts);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", Math.max(nowPage - 4, 1));
        model.addAttribute("endPage", Math.min(nowPage + 5, posts.getTotalPages()));

        return "board/board";
    }
}
