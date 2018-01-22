package model;

import java.util.Date;

public class Transaction {

    private int userId;
    private String userName;
    private Type type;
    private double amount;
    private Date date;

    public enum Type {
        Deposit, Transfer, Withdraw;
    }

    public Transaction(int userId, String userName, Type type, double amount, Date date) {
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
