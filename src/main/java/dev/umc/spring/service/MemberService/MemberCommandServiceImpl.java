package dev.umc.spring.service.MemberService;

import ch.qos.logback.core.status.ErrorStatus;
import dev.umc.spring.base.Code;
import dev.umc.spring.base.exception.handler.FoodCategoryHandler;
import dev.umc.spring.converter.MemberConverter;
import dev.umc.spring.converter.MemberPreferConverter;
import dev.umc.spring.domain.FoodCategory;
import dev.umc.spring.domain.Member;
import dev.umc.spring.domain.mapping.MemberPrefer;
import dev.umc.spring.repository.FoodCategoryRepository;
import dev.umc.spring.repository.MemberRepository;
import dev.umc.spring.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(Code.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

}
