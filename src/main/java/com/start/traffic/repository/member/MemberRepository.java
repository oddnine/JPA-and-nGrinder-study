package com.start.traffic.repository.member;

import com.start.traffic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByName(String name);

    boolean existsByEmailAndPassword(String email, String password); //exist: 데이터가 있는지 없는지
}
