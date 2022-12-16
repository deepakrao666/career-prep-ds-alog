package com.deepak.leetCode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class InvalidTransaction {

    public List<String> invalidTransactions(String[] transactions) {

        Map<String, NavigableMap<Integer, Transaction>> transactionsByName = new HashMap<>();
        Set<Transaction> invalid = new HashSet<>(); // identity hashset
        NavigableMap<Integer, Transaction> transactionsByTime;

        for (String string : transactions) {
            Transaction transaction = new Transaction(string);

            if (transaction.amount > 1000) {
                invalid.add(transaction);
            }
            // map of time and transaction
            transactionsByTime = transactionsByName.computeIfAbsent(transaction.name, name -> new TreeMap<>());

            Collection<Transaction> values = transactionsByTime
                    .subMap(transaction.time - 60, true, transaction.time + 60, true)
                    .values();

            List<Transaction> invalidByTime = values.stream()
                    .filter(t -> !t.city.equals(transaction.city) || t.amount == transaction.amount) // other city or duplicate
                    .collect(Collectors.toList());

            if (!invalidByTime.isEmpty()) {
                invalid.add(transaction);
                invalid.addAll(invalidByTime);
            }
            transactionsByTime.put(transaction.time, transaction);

        }
        return invalid.stream().map(Transaction::toString).collect(Collectors.toList());
    }

    private static class Transaction {

        String name;
        int time;
        int amount;
        String city;

        Transaction(String s) {
            final String[] split = s.split(",");

            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3];

        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}
