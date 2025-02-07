package com.eems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "approvals")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;

	public void setStatus(Object rEJECTED) {
		// TODO Auto-generated method stub

	}

	public void setExpense(Expense expense2) {
		// TODO Auto-generated method stub

	}
}

enum ApprovalStatus {
    PENDING, APPROVED, REJECTED
}