package com.dmy.ygagentserver.module.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderImage {
    private long id;
    private int orderId;
    private String imageUrl;
    private int sort;
    private LocalDateTime createAt;
}
