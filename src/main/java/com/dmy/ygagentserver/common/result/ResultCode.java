package com.dmy.ygagentserver.common.result;

public enum ResultCode {

    SUCCESS(0, "success"),
    USER_NOT_EXIST(1001, "用户不存在"),
    PASSWORD_ERROR(1002, "密码错误"),
    UNSUPPORTED_LOGIN_TYPE(1003, "暂不支持该登录方式"),
    FAIL_BIND(1004,  "绑定学校失败"),
    UNEXIST_SCHOOL(1005,   "学校不存在"),
    UNEXIST_CAMPUS(1006,  "校区不存在"),
    UNMATCH_CAMPUS(1007,  "校区不属于该学校"),
    AAA(1008,  "绑定学校失败"),
    SYSTEM_ERROR(9999, "系统异常");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() { return code; }
    public String msg() { return msg; }
}

