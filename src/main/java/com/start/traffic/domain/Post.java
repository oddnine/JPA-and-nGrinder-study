package com.start.traffic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sentence;
    private String title;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id_fk")
    private Member memberIdFk;

    @Builder
    public Post(Long id, String sentence, String title, LocalDateTime date, Member memberIdFk) {
        this.id = id;
        this.sentence = sentence;
        this.title = title;
        this.date = date == null ? LocalDateTime.now() : date;
        this.memberIdFk = memberIdFk;
    }
}
