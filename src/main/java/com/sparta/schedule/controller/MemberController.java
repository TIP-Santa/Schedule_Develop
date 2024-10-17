package com.sparta.schedule.controller;

import com.sparta.schedule.dto.member.LoginRequestDto;
import com.sparta.schedule.dto.member.MemberRequestDto;
import com.sparta.schedule.dto.member.MemberResponseDto;
import com.sparta.schedule.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 맴버 작성
    @PostMapping
    public MemberResponseDto createMember(@Valid @RequestBody MemberRequestDto createMemberRequestDto) {
        MemberResponseDto responseDto = memberService.createMember(createMemberRequestDto);
        return responseDto;
    }
    @PostMapping("/login")
    public MemberResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse res) {
        MemberResponseDto responseDto = memberService.login(loginRequestDto, res);
        return responseDto;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
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
