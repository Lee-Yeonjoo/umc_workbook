package dev.umc.spring.service.TempService;

import dev.umc.spring.base.Code;
import dev.umc.spring.base.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(Code.TEMP_EXCEPTION);
        }
    }
}
