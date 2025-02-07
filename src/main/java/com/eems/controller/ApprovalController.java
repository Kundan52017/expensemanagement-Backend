package com.eems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eems.dto.ApprovalDTO;
import com.eems.service.ApprovalService;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @PostMapping
    public ResponseEntity<String> requestApproval(@RequestBody ApprovalDTO approvalDTO) {
        return approvalService.requestApproval(approvalDTO);
    }

    @GetMapping
    public ResponseEntity<Object> getAllApprovals() {
        return ResponseEntity.ok(approvalService.getAllApprovals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateApprovalStatus(@PathVariable Long id, @RequestParam String status) {
        return approvalService.updateApprovalStatus(id, status);
    }
}
