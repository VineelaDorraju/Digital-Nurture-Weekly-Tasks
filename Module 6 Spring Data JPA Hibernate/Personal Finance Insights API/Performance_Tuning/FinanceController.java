package com.expense.insights.controller;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.insights.service.FinanceService;
import com.expense.tracker.entity.Transaction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class FinanceController {

    private final FinanceService service;

    public FinanceController(FinanceService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/category")
    public List<CategorySummary> getCategoryReport() {
        return service.getCategoryReport();
    }

    @GetMapping("/monthly")
    public List<MonthlyExpenseDTO> getMonthlyReport() {
        return service.getMonthlyReport();
    }

    @GetMapping("/projection")
    public List<ExpenseProjection> getExpenseProjection() {
        return service.getExpenseProjection();
    }

    @GetMapping("/between")
    public List<Transaction> getTransactionsBetweenDates(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end) {

        return service.getTransactionsBetweenDates(start, end);
    }

    @GetMapping("/average")
    public List<Transaction> getAboveAverageExpenses() {
        return service.getAboveAverageExpenses();
    }

    @GetMapping("/category/{category}")
    public List<Transaction> getTransactionsByCategory(
            @PathVariable String category) {

        return service.getTransactionsByCategory(category);
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getTransactionsByType(
            @PathVariable String type) {

        return service.getTransactionsByType(type);
    }

    @GetMapping("/high-value/{amount}")
    public List<Transaction> getHighValueTransactions(
            @PathVariable Double amount) {

        return service.getHighValueTransactions(amount);
    }

    @GetMapping("/large/{amount}")
    public List<Transaction> getLargeTransactions(
            @PathVariable Double amount) {

        return service.getLargeTransactions(amount);
    }

    @GetMapping("/latest")
    public List<Transaction> getLatestTransactions() {
        return service.getLatestTransactions();
    }

    @GetMapping("/top-expenses")
    public List<Transaction> getTopExpenses() {
        return service.getTopExpenses();
    }

}