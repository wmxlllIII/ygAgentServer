package com.dmy.ygagentserver.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {
    PASSWORD(1, "账号密码"),
    SMS(2, "短信登录"),
    MAIL(3, "邮箱登录");
    private final int code;
    private final String desc;

    public static LoginType fromCode(int code) {
        for (LoginType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("非法的登录类型");
    }
}
