package model;

public class Account implements UserModel{

    private int userId;
    private int accountId;
    private String name;
    private Type type;
    private double balance;
    private Status status;

    public enum Type {
        Savings, Current
    }

    public enum Status {
        Active, Disabled
    }

    public Account(int userId, int accountId, String name, Type type, double balance, Status status) {
        this.userId = userId;
        this.accountId = accountId;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.status = status;
    }

    public Account(String name, Type type, double balance, Status status) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public static String[] getTypes(){
        String types[] = new String[Type.values().length];
        for(int i = 0; i < types.length; i++){
            types[i] = String.valueOf(Type.values()[i]);
        }

        return types;
    }

    public static String[] getStatuses(){
        String statuses[] = new String[Account.Status.values().length];
        for(int i = 0; i < statuses.length; i++){
            statuses[i] = String.valueOf(Account.Status.values()[i]);
        }

        return statuses;
    }
}
