package dev.umc.spring.base.exception.handler;

import dev.umc.spring.base.Code;
import dev.umc.spring.base.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(Code errorCode) {
        super(errorCode);
    }
}
