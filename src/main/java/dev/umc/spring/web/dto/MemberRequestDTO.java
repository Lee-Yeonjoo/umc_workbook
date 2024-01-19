package dev.umc.spring.web.dto;

import dev.umc.spring.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min=1, max = 12) //글자수 안 지키고 요청 보내서 오류가 난거였다.. 한글이라서가 아니라..
        String address;
        @Size(min = 1, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
