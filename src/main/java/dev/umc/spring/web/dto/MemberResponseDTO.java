package dev.umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{ //회원가입 응답의 결과로 멤버아이디와 시간을 보냄.
        Long memberId;
        LocalDateTime createdAt;
    }
}
