package com.dmy.ygagentserver.module.entity;

import lombok.Data;

@Data
public class Location {
    private int id;
    private int campusId;
    private String name;
    private int type;
    private String detail;
    private int sort;
    private int status;
}
