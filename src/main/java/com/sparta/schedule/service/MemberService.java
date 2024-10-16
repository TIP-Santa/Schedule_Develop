package com.sparta.schedule.service;

import com.sparta.schedule.dto.member.MemberRequestDto;
import com.sparta.schedule.dto.member.MemberResponseDto;
import com.sparta.schedule.entity.Member;
import com.sparta.schedule.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // POST
    public MemberResponseDto createMember(MemberRequestDto createMemberRequestDto) {
        Member member = new Member(createMemberRequestDto);
        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember);
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
        member.update(updateMemberRequestDto);
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);
        return memberResponseDto;
    }

    // DELETE
    public Long deleteMember(Long userKey) {
        Member member = findByKey(userKey);
        memberRepository.delete(member);
        return userKey;
    }


    private Member findByKey(Long userKey) {
        return memberRepository.findById(userKey).orElseThrow(() ->
                new RuntimeException("선택한 유저를 찾을 수 없습니다.")
        );
    }
}
