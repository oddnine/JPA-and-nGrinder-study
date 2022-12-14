package com.start.traffic.controller.board;

import com.start.traffic.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostForm {
    private Long id;
    private String title;
    private String sentence;
    private LocalDateTime date;
    private Member memberIdFk;
}
