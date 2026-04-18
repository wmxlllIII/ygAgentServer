package com.dmy.ygagentserver.module.user.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespDTO {

    private Long userId;
    private String username;
    private String token;
}
