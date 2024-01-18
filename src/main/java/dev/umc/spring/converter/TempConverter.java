package dev.umc.spring.converter;

import dev.umc.spring.web.dto.TempRequest;
import dev.umc.spring.web.dto.TempResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
