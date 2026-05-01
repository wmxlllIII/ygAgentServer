package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payments {
    private int id;
    private int taskId;
    private long userId;
    private long runnerId;
    private double amount;
    private int status;
    private int paymentType;
    private LocalDateTime createAt;


}
