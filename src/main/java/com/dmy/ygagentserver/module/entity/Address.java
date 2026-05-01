package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address {
    private int id;
    private long userId;
    private int schoolId;
    private int campusId;
    private int locationId;
    private String detail;
    private int isDefault;
    private LocalDateTime createAt;
}
