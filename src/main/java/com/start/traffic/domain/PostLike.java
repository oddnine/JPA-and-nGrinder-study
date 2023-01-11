package com.start.traffic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id_fk")
    private Member memberIdFk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_fk")
    private Post postIdFk;

    @Builder
    public PostLike(Long id, Member memberIdFk, Post postIdFk) {
        this.id = id;
        this.memberIdFk = memberIdFk;
        this.postIdFk = postIdFk;
    }
}
