package com.eems.dto;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExpenseDTO {
    private Long id;
    private String description;
    private double amount;
    private String category;
    private LocalDateTime date;
}