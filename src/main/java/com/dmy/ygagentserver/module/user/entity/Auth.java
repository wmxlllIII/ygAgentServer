package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Auth {
    private long id;
    private long userId;
    private int phone;
    private String password;
    private int schoolId;
    private int campusId;
    private int status;
    private LocalDateTime createAt;
}
