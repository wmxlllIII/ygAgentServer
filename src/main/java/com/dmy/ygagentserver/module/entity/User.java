package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private long id;
    private long userId;
    private String nickname;
    private String avatarUrl;
    private int schoolId;
    private int campusId;
    private double rating;
    private int gender;
    private int totalOrders;
    private int status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}

