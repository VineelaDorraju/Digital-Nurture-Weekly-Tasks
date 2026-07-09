package com.expense.insights.controller;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.insights.service.FinanceService;
import com.expense.tracker.entity.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class FinanceController {

    private final FinanceService service;

    public FinanceController(FinanceService service) {
        this.service = service;
    }

    @GetMapping("/category")
    public List<CategorySummary> categoryReport() {
        return service.getCategoryReport();
    }

    @GetMapping("/monthly")
    public List<MonthlyExpenseDTO> monthlyReport() {
        return service.getMonthlyReport();
    }

    @GetMapping("/projection")
    public List<ExpenseProjection> expenseProjection() {
        return service.getExpenseProjection();
    }

    @GetMapping("/top-expenses")
    public List<Transaction> topExpenses() {
        return service.getTopExpenses();
    }

}