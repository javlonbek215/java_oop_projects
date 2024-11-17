package atto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Terminal {
    private Integer id;
    private String address;
    private Transaction[] transactionArray = new Transaction[10];
    private int index = 0;

    public void addTransaction(Transaction transaction) {
        if (index == transactionArray.length) {
            Transaction[] newArray = new Transaction[index * 2];
            for (int i = 0; i < transactionArray.length; i++) {
                newArray[i] = transactionArray[i];
            }
            transactionArray = newArray;
        }
        transactionArray[index++] = transaction;
    }

    public double getAmountByDay(String date) {
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

    public Transaction[] transactionsList() {
        return transactionArray;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Terminal [id=" + id + ", address=" + address + "]";
    }

}
