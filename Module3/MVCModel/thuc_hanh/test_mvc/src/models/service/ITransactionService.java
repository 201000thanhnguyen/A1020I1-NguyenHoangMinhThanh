package models.service;

import models.bean.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> transactionList();
    boolean addTransaction(Transaction transaction);
}
