package com.dmy.ygagentserver.common.exception;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.common.result.ResultCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ApiResponse<?> handleBusinessException(BusinessException e) {
        return ApiResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {

        System.out.println("出异常了" + e);
        log.info("Unhandled Exception", e);

        return ApiResponse.error(
                ResultCode.SYSTEM_ERROR.code(),
                ResultCode.SYSTEM_ERROR.msg()
        );
    }
}

