package controllers;

import controllers.manager.Manager;
import controllers.manager.SearchDecorator;
import model.Account;
import model.Response;
import model.Transaction;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CustomerController {

    private Manager<Account> accountManager;
    private Manager<Transaction> transactionManager;

    public CustomerController(Manager<Account> accountManager, Manager<Transaction> transactionManager) {
        this.accountManager = accountManager;
        this.transactionManager = transactionManager;
    }

    public Response withdraw(double amount){
        Account user = getCurrentUserAccount();

        double balance = user.getBalance();

        Response checksResponse = withdrawChecks(balance, amount);

        if(!checksResponse.isSuccess())
            return checksResponse;

        user.setBalance(balance - amount);

        Response response = accountManager.update(user);
        if(response.isSuccess())
            transactionManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Withdraw, amount, new Date()));

        return response;
    }

    private Response withdrawChecks(double balance, double amount){
        //Check for enough balance
        if(balance < amount)
            return new Response(false, "You don't have enough balance");

        //Check for total withdrawals made today
        SearchDecorator.Builder<Transaction> transactionSearch = new SearchDecorator.Builder<>(transactionManager);

        transactionSearch.addQuery(transaction -> CurrentUser.instance().get().getUserId() == transaction.getUserId());
        transactionSearch.addQuery(transaction -> Transaction.Type.Withdraw == transaction.getType());
        transactionSearch.addQuery(transaction -> {
            LocalDate transactionDate = transaction.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate todayDate = LocalDate.now();

            return todayDate.isEqual(transactionDate);
        });

        Manager<Transaction> todayTransactions = transactionSearch.build();

        double totalAmount = 0;
        for(Transaction transaction : todayTransactions.getList()){
            totalAmount = totalAmount + transaction.getAmount();
        }

        if((totalAmount) >= 20000)
            return new Response(false, "You have exceeds the total amount allowed to withdraw in a day, please come tomorrow");

        if((totalAmount + amount) >= 20000)
            return new Response(false, "You can't withdraw " + amount + " because this will exceeds allowed daily withdrawal. You can only withdraw " + (20000 - totalAmount));

        return new Response(true, null);
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

        transactionManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Transfer, amount, new Date()));

        return new Response(true, "Transaction confirmed.");
    }

    public Response deposit(double amount){
        Account user = getCurrentUserAccount();
        user.setBalance(user.getBalance() + amount);

        Response response = accountManager.update(user);

        if(response.isSuccess())
            transactionManager.insert(new Transaction(user.getUserId(), user.getName(), Transaction.Type.Deposit, amount, new Date()));

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
