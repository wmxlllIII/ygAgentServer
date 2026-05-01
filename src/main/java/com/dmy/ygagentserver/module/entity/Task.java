package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private int id;
    private int taskId;
    private long userId;
    private long runnerId;
    private String title;
    private String description;
    private int status;
    private double price;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
