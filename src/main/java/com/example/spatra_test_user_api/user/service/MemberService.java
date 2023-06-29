package com.example.spatra_test_user_api.user.service;

import com.example.spatra_test_user_api.user.dto.MemberResponseDto;
import com.example.spatra_test_user_api.user.entity.Member;
import com.example.spatra_test_user_api.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("회원 상세 조회 실패")
        );
        return new MemberResponseDto(member);
    }

    public List<MemberResponseDto> findAllMember() {
        return memberRepository.findAll().stream().map(MemberResponseDto::new).toList();
    }
}