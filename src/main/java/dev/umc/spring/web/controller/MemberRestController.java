package dev.umc.spring.web.controller;

import dev.umc.spring.base.ApiResponse;
import dev.umc.spring.base.Code;
import dev.umc.spring.converter.MemberConverter;
import dev.umc.spring.domain.Member;
import dev.umc.spring.service.MemberService.MemberCommandService;
import dev.umc.spring.web.dto.MemberRequestDTO;
import dev.umc.spring.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(/*@Valid*/ @RequestBody MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
