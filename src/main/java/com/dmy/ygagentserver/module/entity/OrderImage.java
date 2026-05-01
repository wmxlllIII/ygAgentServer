package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderImage {
    private int id;
    private int orderId;
    private String imageUrl;
    private int sort;
    private LocalDateTime createAt;
}
