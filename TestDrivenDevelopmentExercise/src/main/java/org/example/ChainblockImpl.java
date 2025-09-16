package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer,Transaction> database;

    public ChainblockImpl() {
        this.database = new TreeMap<>();
    }

    public int getCount() {
        return database.size();
    }

    public void add(Transaction transaction) {
        database.putIfAbsent(transaction.getId(),transaction);

    }

    public boolean contains(Transaction transaction) {
        return database.containsValue(transaction);
    }

    public boolean contains(int id) {
        return database.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        validateTransactionExistById(id);
        database.get(id).setStatus(newStatus);

    }



    public void removeTransactionById(int id) {
        validateTransactionExistById(id);
        database.remove(id);

    }

    public Transaction getById(int id) {
        validateTransactionExistById(id);
        return database.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
     return  filterByStatus(status);


    }



    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        return  filterByStatus(status).stream().map(Transaction::getFrom).toList();

    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return  filterByStatus(status).stream().map(Transaction::getTo).toList();
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        if (database.isEmpty()){
            throw new IllegalArgumentException();
        }
        List<Transaction> transactionList = database.values().stream().toList();

        return transactionList.stream().sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId)).toList();
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private List<Transaction> filterByStatus(TransactionStatus status) {
        List<Transaction> list = database.values().stream().filter(t -> t.getStatus().equals(status)).sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list;
    }



    private void validateTransactionExistById(int id) {
        if (!database.containsKey(id)){
            throw  new IllegalArgumentException();
        }
    }
}
