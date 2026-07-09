package com.expense.tracker.service;

import com.expense.tracker.entity.Transaction;
import com.expense.tracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public Transaction getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Transaction update(Long id, Transaction transaction) {

        Transaction old = repository.findById(id).orElse(null);

        if (old != null) {
            old.setAmount(transaction.getAmount());
            old.setType(transaction.getType());
            old.setDate(transaction.getDate());
            old.setCategory(transaction.getCategory());
            old.setUser(transaction.getUser());

            return repository.save(old);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Transaction> getByType(String type) {
        return repository.findByType(type);
    }

    public List<Transaction> getByCategory(String category) {
        return repository.findByCategoryName(category);
    }

    public List<Transaction> getByUser(String email) {
        return repository.findByUserEmail(email);
    }

    public Page<Transaction> getPage(int page, int size, String sortBy) {

        Pageable pageable =
                PageRequest.of(page, size, Sort.by(sortBy));

        return repository.findAll(pageable);
    }

}