package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(String username);
    boolean existsByUserEmail(String email);

    Optional<Member> findByUserEmail(String email);
}
