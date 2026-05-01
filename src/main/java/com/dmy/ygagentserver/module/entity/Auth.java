package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Auth {
    private int id;
    private long userId;
    private int phone;
    private String password;
    private int schoolId;
    private int campusId;
    private int status;
    private LocalDateTime createAt;
}
