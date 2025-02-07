package com.eems.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eems.dto.ExpenseDTO;
import com.eems.model.Expense;
import com.eems.repository.ExpenseRepository;
import com.eems.repository.UserRepository;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Expense createExpense(Long userId, Expense expense) {
        Optional<com.eems.model.User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        expense.setUser(user.get());
        expense.setDate(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setDescription(updatedExpense.getDescription());
            expense.setAmount(updatedExpense.getAmount());
            expense.setCategory(updatedExpense.getCategory());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public ResponseEntity<String> deleteExpense(Long id) {
        expenseRepository.deleteById(id);
		return null;
    }

	public ResponseEntity<String> addExpense(ExpenseDTO expenseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAllExpenses() {
		// TODO Auto-generated method stub
		return null;
	}
}