package com.eems.dto;

import lombok.Data;

@Data
public class ApprovalDTO {
    private Long id;
    private Long expenseId;
    private String status;
}
