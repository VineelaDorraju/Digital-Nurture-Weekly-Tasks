package com.expense.insights.repository;

import com.expense.insights.dto.CategorySummary;
import com.expense.insights.dto.ExpenseProjection;
import com.expense.insights.dto.MonthlyExpenseDTO;
import com.expense.tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Transaction, Long> {

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

    @Query(value="""
            SELECT *
            FROM transactions
            ORDER BY amount DESC
            LIMIT 5
            """,nativeQuery=true)
    List<Transaction> getTopExpenses();

}