package com.dmy.ygagentserver.module.user.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindSchoolRespDTO {
    private boolean success;
    private String message;
}
