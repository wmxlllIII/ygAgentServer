package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private Long userId;
    private String nickname;
    private String avatar;
    private int gender;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}

