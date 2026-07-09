package com.expense.tracker.repository;

import com.expense.tracker.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByType(String type);

    List<Transaction> findByAmountGreaterThan(Double amount);

    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);

    List<Transaction> findByCategoryName(String name);

    List<Transaction> findByUserEmail(String email);

    Page<Transaction> findAll(Pageable pageable);

}