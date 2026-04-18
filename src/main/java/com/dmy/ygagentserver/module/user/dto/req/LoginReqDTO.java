package com.dmy.ygagentserver.module.user.dto.req;

import com.dmy.ygagentserver.common.enums.LoginType;
import lombok.Data;

@Data
public class LoginReqDTO {
    private LoginType loginType;
    private String account;
    private String password;
}
