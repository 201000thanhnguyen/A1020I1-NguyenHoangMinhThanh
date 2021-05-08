package models.service.ipml;

import models.bean.Transaction;
import models.repository.ITransactionRepository;
import models.repository.impl.TransactionRepository;
import models.service.ITransactionService;

import java.util.List;

public class TransactionService implements ITransactionService {

    private ITransactionRepository transactionRepository = new TransactionRepository();

    @Override
    public List<Transaction> transactionList() {
        return this.transactionRepository.transactionList();
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        return transactionRepository.addTransaction(transaction);
    }
}
