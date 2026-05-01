package com.dmy.ygagentserver.module.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationRespDTO {
    private int schoolId;
    private String schoolName;
    private int campusId;
    private String campusName;
    private String detail;
    private int sort;
    private int status;
    private int type;
}
