package com.sparta.schedule.dto.member;

import com.sparta.schedule.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {
    private Long userKey;
    private String userName;
    private String userEmail;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    public MemberResponseDto(Member savedMember) {
        this.userKey = savedMember.getUserKey();
        this.userName = savedMember.getUserName();
        this.userEmail = savedMember.getUserEmail();
        this.createdDateTime = savedMember.getCreatedDateTime();
        this.modifiedDateTime = savedMember.getModifiedDateTime();
    }
}
