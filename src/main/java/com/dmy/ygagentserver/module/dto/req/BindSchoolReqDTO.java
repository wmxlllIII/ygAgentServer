package com.dmy.ygagentserver.module.dto.req;

import lombok.Data;

@Data
public class BindSchoolReqDTO {
    private long userId;
    private int schoolId;
    private int campusId;
}
