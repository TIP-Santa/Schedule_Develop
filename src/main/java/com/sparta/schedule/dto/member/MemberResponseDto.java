package com.sparta.schedule.dto.member;

import com.sparta.schedule.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long userKey;
    private String userName;
    private String userEmail;

    public MemberResponseDto(Member savedMember) {
        this.userKey = savedMember.getUserKey();
        this.userName = savedMember.getUserName();
        this.userEmail = savedMember.getUserEmail();
    }
}
