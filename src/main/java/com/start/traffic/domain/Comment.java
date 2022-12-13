package com.start.traffic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id_fk")
    private Member memberIdFk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_fk")
    private Post postIdFk;

    @Builder
    public Comment(Long id, LocalDateTime date, Member memberIdFk, Post postIdFk) {
        this.id = id;
        this.date = date == null ? LocalDateTime.now() : date;
        this.memberIdFk = memberIdFk;
        this.postIdFk = postIdFk;
    }
}
