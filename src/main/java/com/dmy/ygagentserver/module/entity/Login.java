package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Login {
    private int id;
    private long userId;
    private int loginType;
    private String account;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
