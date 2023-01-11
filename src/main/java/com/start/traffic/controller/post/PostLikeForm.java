package com.start.traffic.controller.post;

import com.start.traffic.domain.Member;
import com.start.traffic.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class PostLikeForm {
    private Long id;
    private Member memberIdFk;
    private Post postIdFk;
}
