package com.expense.insights.service;

import com.expense.insights.repository.FinanceRepository;
import com.expense.tracker.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchTransactionService {

    private final FinanceRepository repository;

    public BatchTransactionService(FinanceRepository repository) {
        this.repository = repository;
    }

    public void saveTransactions(List<Transaction> transactions) {
        repository.saveAll(transactions);
    }

}