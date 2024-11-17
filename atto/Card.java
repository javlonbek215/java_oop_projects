package atto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Card {
    private Integer id;
    private double balance;
    private Transaction[] transactionArray = new Transaction[10];
    private int index = 0;

    public Transaction[] todayTransactionList() {
        LocalDate today = LocalDate.now();
        Transaction[] tempArr = new Transaction[index];
        int tempIndex = 0;

        for (Transaction t : transactionArray) {
            if (t != null && t.getCreatDate().toLocalDate().isEqual(today)) {
                tempArr[tempIndex++] = t;
            }
        }
        return tempArr;
    }

    public void addTransaction(Transaction transaction) {
        if (transactionArray.length == index) {
            Transaction[] newArray = new Transaction[transactionArray.length * 2];
            for (int i = 0; i < transactionArray.length; i++) {
                newArray[i] = transactionArray[i];
            }
            transactionArray = newArray;
        }
        transactionArray[index++] = transaction;
    }

    // berilgan kun bo'yicha ishlatilgan pul miqdori yyyy.MM.dd
    public double getTransactionAmountByDay(String date) {
        double amount = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        for (Transaction transaction : transactionArray) {
            if (transaction != null && transaction.getCreatDate().toLocalDate().isEqual(localDate)) {
                amount += transaction.getFair();
            }
        }
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Card [id=" + id + ", balance=" + balance + "]";
    }

}
