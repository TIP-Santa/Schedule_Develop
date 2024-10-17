package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserName(String userName);
    boolean existsByUserEmail(String email);

}
