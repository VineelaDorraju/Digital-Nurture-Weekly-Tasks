package com.expense.insights.repository;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.tracker.entity.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FinanceRepository extends JpaRepository<Transaction, Long> {

    @EntityGraph(attributePaths = {"category"})
    List<Transaction> findAll();

    @EntityGraph(attributePaths = {"user", "category"})
    List<Transaction> findByType(String type);

    @Query("""
            SELECT
            t.category.name AS category,
            SUM(t.amount) AS totalAmount
            FROM Transaction t
            GROUP BY t.category.name
            """)
    List<CategorySummary> getCategoryReport();

    @Query("""
            SELECT new com.expense.insights.dto.MonthlyExpenseDTO(
            MONTH(t.date),
            SUM(t.amount))
            FROM Transaction t
            GROUP BY MONTH(t.date)
            ORDER BY MONTH(t.date)
            """)
    List<MonthlyExpenseDTO> getMonthlyReport();

    @Query("""
            SELECT
            t.amount AS amount,
            t.type AS type,
            t.category.name AS category
            FROM Transaction t
            """)
    List<ExpenseProjection> getExpenseProjection();

    @Query("""
            SELECT t
            FROM Transaction t
            WHERE t.date BETWEEN :startDate AND :endDate
            """)
    List<Transaction> findTransactionsBetweenDates(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("""
            SELECT t
            FROM Transaction t
            WHERE t.amount >
            (SELECT AVG(x.amount) FROM Transaction x)
            """)
    List<Transaction> findAboveAverageExpenses();

    @Query("""
            SELECT t
            FROM Transaction t
            WHERE t.category.name = :category
            """)
    List<Transaction> findByCategory(
            @Param("category") String category);

    List<Transaction> findByAmountGreaterThan(Double amount);

    @Query("""
            SELECT t
            FROM Transaction t
            JOIN FETCH t.category
            WHERE t.amount > :amount
            """)
    List<Transaction> fetchLargeTransactions(
            @Param("amount") Double amount);

    @Query("""
            SELECT t
            FROM Transaction t
            ORDER BY t.date DESC
            """)
    List<Transaction> latestTransactions();

    @Query(value = """
            SELECT *
            FROM transactions
            ORDER BY amount DESC
            LIMIT 5
            """,
            nativeQuery = true)
    List<Transaction> getTopExpenses();

}