package com.sparta.schedule.entity;

import com.sparta.schedule.dto.member.MemberRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Member")
@NoArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userKey;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberSchedule> memberSchedules = new ArrayList<>();

    public Member(MemberRequestDto createMemberRequestDto) {
        this.username = createMemberRequestDto.getUsername();
        this.userEmail = createMemberRequestDto.getUserEmail();
        this.password = createMemberRequestDto.getPassword();
    }

    public void update(MemberRequestDto updateMemberRequestDto) {
        this.userEmail = updateMemberRequestDto.getUserEmail();
    }
}
