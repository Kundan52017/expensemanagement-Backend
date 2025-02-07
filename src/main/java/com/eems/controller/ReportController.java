package com.eems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eems.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{month}")
    public ResponseEntity<Object> getReportByMonth(@PathVariable String month) {
        return ResponseEntity.ok(reportService.getReportByMonth(month));
    }

    @GetMapping
    public ResponseEntity<Object> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }
}