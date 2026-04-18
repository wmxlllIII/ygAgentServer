package com.dmy.ygagentserver.module.user.dto.req;

import lombok.Data;

@Data
public class BindSchoolReqDTO {
    private long userId;
    private int schoolId;
    private int campusId;
}
