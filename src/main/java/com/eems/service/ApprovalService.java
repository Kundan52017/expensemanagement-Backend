package com.eems.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eems.dto.ApprovalDTO;
import com.eems.model.Approval;
import com.eems.model.Expense;
import com.eems.repository.ApprovalRepository;
import com.eems.repository.ExpenseRepository;

@Service
public class ApprovalService {
    private final ApprovalRepository approvalRepository;
    private final ExpenseRepository expenseRepository;

    public ApprovalService(ApprovalRepository approvalRepository, ExpenseRepository expenseRepository) {
        this.approvalRepository = approvalRepository;
        this.expenseRepository = expenseRepository;
    }

    public Approval requestApproval(Long expenseId) {
        Optional<Expense> expense = expenseRepository.findById(expenseId);
        if (expense.isEmpty()) {
            throw new RuntimeException("Expense not found");
        }

        Approval approval = new Approval();
        approval.setExpense(expense.get());
        approval.setStatus(ApprovalStatus.PENDING);
        return approvalRepository.save(approval);
    }

    public Approval approveExpense(Long approvalId) {
        return approvalRepository.findById(approvalId).map(approval -> {
            approval.setStatus(ApprovalStatus.APPROVED);
            return approvalRepository.save(approval);
        }).orElseThrow(() -> new RuntimeException("Approval request not found"));
    }

    public Approval rejectExpense(Long approvalId) {
        return approvalRepository.findById(approvalId).map(approval -> {
            approval.setStatus(ApprovalStatus.REJECTED);
            return approvalRepository.save(approval);
        }).orElseThrow(() -> new RuntimeException("Approval request not found"));
    }

	public Object getAllApprovals() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> updateApprovalStatus(Long id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> requestApproval(ApprovalDTO approvalDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
