package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private int id;
    private long userId;
    private int type;
    private int businessId;
    private String title;
    private String content;
    private LocalDateTime createAt;
}
