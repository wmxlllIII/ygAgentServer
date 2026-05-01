package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private int id;
    private long publisherId;
    private long accepterId;
    private int status;
    private double reward;
    private LocalDateTime createTime;
    private LocalDateTime acceptTime;
    private LocalDateTime finishTime;
    private LocalDateTime cancelTime;
}
