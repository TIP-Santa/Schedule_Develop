package com.sparta.schedule.controller;

import com.sparta.schedule.dto.member.LoginRequestDto;
import com.sparta.schedule.dto.member.MemberRequestDto;
import com.sparta.schedule.dto.member.MemberResponseDto;
import com.sparta.schedule.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // error Test
    @GetMapping("/error")
    public ResponseEntity<String> throwError() {
        throw new IllegalArgumentException("테스트용 오류 발생!");
    }

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody MemberRequestDto createMemberRequestDto) {
        memberService.signup(createMemberRequestDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        try {
            memberService.login(requestDto, response);
            return ResponseEntity.ok("정상적으로 로그인되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        try {
            memberService.logout(response);
            return ResponseEntity.ok("정상적으로 로그아웃되었습니다.");
        } catch (Exception e) {
            log.error("Logout error: {}", e.getMessage());
            throw new RuntimeException("Logout Failed", e);
        }
    }

    // 특정 유저 조회
    @GetMapping("/{userKey}")
    public MemberResponseDto getMember(@PathVariable Long userKey) {
        return memberService.getMember(userKey);
    }

    // 특정 유저 정보 수정
    @PutMapping("/{userKey}")
    public MemberResponseDto updateMember(@PathVariable Long userKey, @Valid @RequestBody MemberRequestDto updateMemberRequestDto) {
        return memberService.updateMember(userKey, updateMemberRequestDto);
    }

    // 특정 유저 삭제
    @DeleteMapping("/{userKey}")
    public Long deleteMember(@PathVariable Long userKey, @Valid @RequestBody MemberRequestDto deleteMemberRequestDto) {
        return memberService.deleteMember(userKey, deleteMemberRequestDto);
    }
}
