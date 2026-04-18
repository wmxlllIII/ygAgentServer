package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private long id;
    private long publisherId;
    private long accepterId;
    private int status;
    private double reward;
    private LocalDateTime createTime;
    private LocalDateTime acceptTime;
    private LocalDateTime finishTime;
    private LocalDateTime cancelTime;
}
