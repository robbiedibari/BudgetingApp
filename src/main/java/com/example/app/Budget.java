package com.example.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Budget {
    private final ObservableList<Transaction> transactions;

    public Budget(){
        transactions = FXCollections.observableArrayList();
    }
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public ObservableList<Transaction> getTransactions(){
        return transactions;
    }

    public double getTotalIncome(){
        return transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.INCOME).mapToDouble(Transaction::getAmount).sum();
    }

    public double getTotalExpense(){
        return transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.EXPENSE).mapToDouble(Transaction::getAmount).sum();

    }

}
