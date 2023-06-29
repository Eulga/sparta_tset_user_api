package com.example.spatra_test_user_api.user.contoller;

import com.example.spatra_test_user_api.user.dto.MemberResponseDto;
import com.example.spatra_test_user_api.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMember(id));
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/member")
    public ResponseEntity<List<MemberResponseDto>> getMemberList() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAllMember());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String,String>> nullPointerExceptionHandler(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "NullPointerException", "code", "400", "message", e.getMessage()));
    }
}
