package controllers;

import controllers.manager.Manager;
import controllers.manager.Response;
import model.Account;
import model.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerController {

    private Manager<Account> accountManager;
    private Manager<Transaction> transferManager;

    public CustomerController(Manager<Account> accountManager, Manager<Transaction> transferManager) {
        this.accountManager = accountManager;
        this.transferManager = transferManager;
    }

    public Response withdraw(double amount){
        Account user = getCurrentUserAccount();

        double balance = user.getBalance();

        if(balance < amount)
            return new Response(false, "You don't have enough balance");

        user.setBalance(balance - amount);

        Response response = accountManager.update(user);
        if(response.isSuccess())
            transferManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Withdraw, amount, new Date()));

        return response;
    }

    public Response transfer(double amount, int accountId){
        Account user = getCurrentUserAccount();

        double balance = user.getBalance();

        if(balance < amount)
            return new Response(false, "You don't have enough balance");

        Account recipient = accountManager.get(account -> account.getAccountId() == accountId);

        if(recipient == null)
            return new Response(false, "The recipient dose not exist");

        if(user.getUserId() == recipient.getUserId())
            return new Response(false, "You can't transfer money to yourself");

        user.setBalance(user.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        accountManager.update(user);
        accountManager.update(recipient);

        transferManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Transfer, amount, new Date()));

        return new Response(true, "Transaction confirmed.");
    }

    public Response deposit(double amount){
        Account user = getCurrentUserAccount();
        user.setBalance(user.getBalance() + amount);

        Response response = accountManager.update(user);

        if(response.isSuccess())
            transferManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Deposit, amount, new Date()));

        return response;
    }

    public void displayBalance(){
        displayBalance(null);
    }

    public void displayBalance(String extraInfo){
        Account user = getCurrentUserAccount();
        System.out.println("Account: #" + user.getAccountId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        System.out.println("Date: " + dateFormat.format(new Date()) + "\n");

        if(extraInfo != null)
            System.out.println(extraInfo);
        System.out.println("Balance: " + user.getBalance());
    }

    public Account getAccount(int id){
        return accountManager.get(u -> u.getAccountId() == id);
    }

    private Account getCurrentUserAccount(){
        return accountManager.get(account -> account.getUserId() == CurrentUser.instance().get().getUserId());
    }

}
