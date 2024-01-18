package dev.umc.spring.base.exception.handler;

import dev.umc.spring.base.Code;
import dev.umc.spring.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(Code erroCode) {
        super(erroCode);
    }
}
