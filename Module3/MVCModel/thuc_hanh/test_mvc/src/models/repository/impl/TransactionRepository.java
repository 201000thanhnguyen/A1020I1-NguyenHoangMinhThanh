package models.repository.impl;

import models.bean.Transaction;
import models.repository.ITransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransactionRepository implements ITransactionRepository {

    private static Map<Integer, Transaction> transactionMap = new TreeMap<>();

    static {
        transactionMap.put(1, new Transaction("trans1", 999.0, "/Images/traibong.jpg"));
        transactionMap.put(2, new Transaction("trans2", 998.0, "/Images/traibong.jpg"));
        transactionMap.put(3, new Transaction("trans3", 997.0, "/Images/traibong.jpg"));
    }

    @Override
    public List<Transaction> transactionList() {
        return new ArrayList<>(transactionMap.values());
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        int id = (int)(Math.random()*1000);
        transactionMap.put(id,transaction);
        return true;
    }
}
