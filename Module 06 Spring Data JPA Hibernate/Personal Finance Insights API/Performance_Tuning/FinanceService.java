package com.expense.insights.service;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.insights.repository.FinanceRepository;
import com.expense.tracker.entity.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository repository;

    public FinanceService(FinanceRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public List<Transaction> getTransactionsByType(String type) {
        return repository.findByType(type);
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

    public List<Transaction> getTransactionsBetweenDates(
            LocalDate startDate,
            LocalDate endDate) {

        return repository.findTransactionsBetweenDates(startDate, endDate);
    }

    public List<Transaction> getAboveAverageExpenses() {
        return repository.findAboveAverageExpenses();
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Transaction> getHighValueTransactions(Double amount) {
        return repository.findByAmountGreaterThan(amount);
    }

    public List<Transaction> getLargeTransactions(Double amount) {
        return repository.fetchLargeTransactions(amount);
    }

    public List<Transaction> getLatestTransactions() {
        return repository.latestTransactions();
    }

    public List<Transaction> getTopExpenses() {
        return repository.getTopExpenses();
    }

}