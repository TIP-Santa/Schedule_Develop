package com.sparta.schedule.service;

import com.sparta.schedule.config.PasswordEncoder;
import com.sparta.schedule.dto.member.MemberRequestDto;
import com.sparta.schedule.dto.member.MemberResponseDto;
import com.sparta.schedule.entity.Member;
import com.sparta.schedule.jwt.JwtUtil;
import com.sparta.schedule.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // POST
    public MemberResponseDto createMember(MemberRequestDto createMemberRequestDto) {
        Member member = new Member(createMemberRequestDto);
        member.setPassword(passwordEncoder.encode(createMemberRequestDto.getPassword()));
        memberRepository.save(member);
        String jwtToken = jwtUtil.createToken(member.getUserName(), member.getUserRole());
        return new MemberResponseDto(member, jwtToken);
    }

    // GET
    public MemberResponseDto getMember(Long userKey){
        Member member = findByKey(userKey);
        return new MemberResponseDto(member);
    }

    // PUT
    @Transactional
    public MemberResponseDto updateMember(Long userKey, MemberRequestDto updateMemberRequestDto) {
        Member member = findByKey(userKey);

        if(!passwordEncoder.matches(updateMemberRequestDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        member.update(updateMemberRequestDto);
        member.setPassword(passwordEncoder.encode(updateMemberRequestDto.getPassword()));
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);
        return memberResponseDto;
    }

    // DELETE
    public Long deleteMember(Long userKey, MemberRequestDto deleteMemberRequestDto) {
        Member member = findByKey(userKey);
        if(!passwordEncoder.matches(deleteMemberRequestDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        memberRepository.delete(member);
        return userKey;
    }


    private Member findByKey(Long userKey) {
        return memberRepository.findById(userKey).orElseThrow(() ->
                new RuntimeException("선택한 유저를 찾을 수 없습니다.")
        );
    }
}
