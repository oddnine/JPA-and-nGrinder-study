package com.start.traffic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_fk")
    private Post postIdFk;

    @Builder
    public Hashtag(Long id, String category, Post postIdFk) {
        this.id = id;
        this.category = category;
        this.postIdFk = postIdFk;
    }
}
