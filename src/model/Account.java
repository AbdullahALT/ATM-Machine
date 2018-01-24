package model;

public class Account implements UserModel{

    private int userId;
    private int accountId;
    private String name;
    private String type;
    private double balance;
    private String status;

    public enum Type {
        Saving, Current
    }

    public enum Status {
        Active, Disabled
    }

    public Account(int userId, int accountId, String name, String type, double balance, String status) {
        this.userId = userId;
        this.accountId = accountId;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.status = status;
    }

    public Account(String name, String type, double balance, String status) {
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account #" + accountId + "\n" +
                "Type: " + type + "\n" +
                "Holder: " + name + "\n" +
                "Balance: " + balance + "\n" +
                "Status: " + status;
    }
}
