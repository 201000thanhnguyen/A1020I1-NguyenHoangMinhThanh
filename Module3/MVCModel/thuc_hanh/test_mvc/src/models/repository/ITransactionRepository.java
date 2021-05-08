package models.repository;

import models.bean.Transaction;

import java.util.List;

public interface ITransactionRepository {
    List<Transaction> transactionList();
    boolean addTransaction(Transaction transaction);
}
