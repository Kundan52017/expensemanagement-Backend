package com.eems.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double amount;

    private String category;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id" ,nullable = false)
    private User user;

	public void setUser(User user2) {
		// TODO Auto-generated method stub

	}

	public void setDate(LocalDateTime now) {
		// TODO Auto-generated method stub

	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(Object description2) {
		// TODO Auto-generated method stub

	}

	public double getAmount() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	public void setAmount(Object amount2) {
		// TODO Auto-generated method stub

	}

	public Object getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCategory(Object category2) {
		// TODO Auto-generated method stub

	}

	public LocalDate getDate() {
		// TODO Auto-generated method stub
		return null;
	}
}