package com.eems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eems.dto.ExpenseDTO;
import com.eems.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> addExpense(@RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }

    @GetMapping
    public ResponseEntity<Object> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        return expenseService.deleteExpense(id);
    }
}