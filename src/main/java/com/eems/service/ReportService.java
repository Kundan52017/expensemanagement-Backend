package com.eems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eems.model.Expense;
import com.eems.model.Report;
import com.eems.repository.ExpenseRepository;
import com.eems.repository.ReportRepository;

@Service
public class ReportService {
    private final ExpenseRepository expenseRepository;
    private final ReportRepository reportRepository;

    public ReportService(ExpenseRepository expenseRepository, ReportRepository reportRepository) {
        this.expenseRepository = expenseRepository;
        this.reportRepository = reportRepository;
    }

    public Report generateMonthlyReport(String month) {
        List<Expense> expenses = expenseRepository.findAll();
        double totalExpense = expenses.stream()
                .filter(expense -> expense.getDate().getMonth().toString().equalsIgnoreCase(month))
                .mapToDouble(Expense::getAmount)
                .sum();

        Report report = new Report();
        report.setMonth(month);
        report.setTotalExpense(totalExpense);

        return reportRepository.save(report);
    }

	public Object getReportByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAllReports() {
		// TODO Auto-generated method stub
		return null;
	}
}