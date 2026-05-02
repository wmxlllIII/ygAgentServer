package com.dmy.ygagentserver.module.vo;

import lombok.Data;

@Data
public class SchoolVO {
    private int id;
    private int schoolId;
    private String schoolName;
    private String province;
    private String city;

    private int campusId;
    private String campusName;
}
