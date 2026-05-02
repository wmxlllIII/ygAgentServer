package com.dmy.ygagentserver.module.dto.req;

import lombok.Data;

@Data
public class RegisterReqDTO {
    private String studentId;
    private String phone;
    private String password;
}
