package com.start.traffic.controller.post;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentForm {
    private Long id;
    private String sentence;
    private Member memberIdFk;
    private Post postIdFk;
}
