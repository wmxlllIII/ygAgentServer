package com.dmy.ygagentserver.module.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class School {
    private int id;
    private String name;
    private String pinyin;
    private String first_letter;
    private String province;
    private String city;
    private String address;
    private String logo;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
}
