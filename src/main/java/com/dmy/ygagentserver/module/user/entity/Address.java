package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address {
    private long id;
    private long userId;
    private int schoolId;
    private int campusId;
    private int locationId;
    private String detail;
    private int isDefault;
    private LocalDateTime createAt;
}
