package com.start.traffic.dto;

import com.start.traffic.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String sentence;
    private String title;
    private LocalDateTime date;
    private Member memberIdFk;

    public PostDto(Long id, String sentence, String title, LocalDateTime date, Member memberIdFk) {
        this.id = id;
        this.sentence = sentence;
        this.title = title;
        this.date = date;
        this.memberIdFk = memberIdFk;
    }
}
