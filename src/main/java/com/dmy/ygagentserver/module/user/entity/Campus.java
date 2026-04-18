package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Campus {
    private long id;
    private int schoolId;
    private String name;
    private String address;
    private LocalDateTime createAt;
}
