package dev.umc.spring.validation.annotation;

import dev.umc.spring.validation.validator.CategoriesExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션이란 뜻.
@Constraint(validatedBy = CategoriesExistValidator.class)  //해당 클래스를 통해 이 어노테이션이 붙은 대상을 검증.
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //어노테이션의 적용범위. 메소드, 필드, 파라미터
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 생명주기 -> 런타임 상에서만 살아있다.
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
