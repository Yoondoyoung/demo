package com.skeleton.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calendar {

    private String startDate;
    private String endDate;
    private String title;
    private String userId;
}
