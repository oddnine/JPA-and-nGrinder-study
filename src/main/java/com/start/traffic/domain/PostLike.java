package com.start.traffic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
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
}
