package com.example.app;

import java.time.LocalDate;

public class Transaction {

    // Enum for TransactionType
    public enum TransactionType {
        INCOME,
        EXPENSE
    }

    private String name;
    private TransactionType type;
    private Double amount;
    private LocalDate date;

    public Transaction(String name, TransactionType type, Double amount, LocalDate date) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
