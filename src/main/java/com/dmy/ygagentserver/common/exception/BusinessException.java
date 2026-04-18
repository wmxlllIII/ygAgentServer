package com.dmy.ygagentserver.common.exception;

import com.dmy.ygagentserver.common.result.ResultCode;

public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.msg());
        this.code = resultCode.code();
    }

    public int getCode() {
        return code;
    }
}

