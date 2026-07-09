package com.expense.insights.controller;

import com.expense.insights.service.BatchTransactionService;
import com.expense.tracker.entity.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchController {

    private final BatchTransactionService service;

    public BatchController(BatchTransactionService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String saveBatch(@RequestBody List<Transaction> transactions) {

        service.saveTransactions(transactions);

        return "Batch inserted successfully.";

    }

}