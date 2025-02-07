package com.eems.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private Long id;
    private String month;
    private double totalExpense;
}