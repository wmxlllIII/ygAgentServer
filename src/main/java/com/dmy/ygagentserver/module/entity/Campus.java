package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Campus {
    private int id;
    private int schoolId;
    private String name;
    private String address;
    private LocalDateTime createAt;
}
