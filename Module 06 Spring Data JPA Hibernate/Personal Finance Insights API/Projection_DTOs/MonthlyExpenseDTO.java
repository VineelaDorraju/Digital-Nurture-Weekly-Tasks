package com.expense.insights.dto;

public class MonthlyExpenseDTO {

    private Integer month;
    private Double totalAmount;

    public MonthlyExpenseDTO() {
    }

    public MonthlyExpenseDTO(Integer month, Double totalAmount) {
        this.month = month;
        this.totalAmount = totalAmount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

}