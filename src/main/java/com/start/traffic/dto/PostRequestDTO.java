package com.start.traffic.dto;

import com.start.traffic.domain.Member;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
public class PostRequestDTO {
    private Long id;
    private String sentence;
    private String title;
    private LocalDateTime date;
    private Member memberIdFk;
}
