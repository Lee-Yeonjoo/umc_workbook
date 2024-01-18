package dev.umc.spring.service.MemberService;

import dev.umc.spring.domain.Member;
import dev.umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);
}
