package com.expense.insights.service;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.insights.repository.FinanceRepository;
import com.expense.tracker.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository repository;

    public FinanceService(FinanceRepository repository) {
        this.repository = repository;
    }

    public List<CategorySummary> getCategoryReport() {
        return repository.getCategoryReport();
    }

    public List<MonthlyExpenseDTO> getMonthlyReport() {
        return repository.getMonthlyReport();
    }

    public List<ExpenseProjection> getExpenseProjection() {
        return repository.getExpenseProjection();
    }

    public List<Transaction> getTopExpenses() {
        return repository.getTopExpenses();
    }

}