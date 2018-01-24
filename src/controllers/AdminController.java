package controllers;

import controllers.manager.Manager;
import controllers.manager.SearchDecorator;
import model.Account;
import model.Login;
import model.Response;
import model.Transaction;

import java.util.Date;

public class AdminController {

    private Manager<Account> accountManager;
    private Manager<Transaction> transferManager;
    private Manager<Login> loginManager;

    public AdminController(Manager<Account> accountManager, Manager<Transaction> transferManager, Manager<Login> loginManager) {
        this.accountManager = accountManager;
        this.transferManager = transferManager;
        this.loginManager = loginManager;
    }

    //create users
    public Response createUser(Login login, Account account){
        Response loginResponse = loginManager.insert(login);

        if(!loginResponse.isSuccess())
            return loginResponse;

        accountManager.insert(account);

        Login result = loginManager.get(u -> u.getLogin().equals(login.getLogin()));
        int accountId = accountManager.get(u -> u.getUserId() == result.getUserId()).getAccountId();

        return new Response(true, "Account Successfully Created – the account number assigned is: " + accountId);
    }

    //delete users
    public Response deleteUser(Account account){
        Login login = loginManager.get(u -> u.getUserId() == account.getUserId());

        Response loginResponse = loginManager.remove(login);
        Response accountResponse = accountManager.remove(account);

        if(!loginResponse.isSuccess() || !accountResponse.isSuccess())
            return new Response(false, loginResponse.getMessage() + "\n" + accountResponse.getMessage());

        return new Response(true, "User Deleted Successfully");
    }

    //search accounts
    public Manager<Account> searchAccounts(int userId, int accountId, String holderName, String type, double balance, String status){
        SearchDecorator.Builder<Account> searchBuilder = new SearchDecorator.Builder<>(accountManager);

        if(userId != -1)
            searchBuilder.addQuery(u -> u.getUserId() == userId);

        if(accountId != -1)
            searchBuilder.addQuery(u -> u.getAccountId() == accountId);

        if(balance != -1)
            searchBuilder.addQuery(u -> u.getBalance() == balance);

        if(!status.equals(""))
            searchBuilder.addQuery(u -> u.getStatus().equals(Account.Status.valueOf(status)));

        if(!holderName.equals(""))
            searchBuilder.addQuery(u -> u.getName().equals(holderName));

        if(!type.equals(""))
            searchBuilder.addQuery(u -> u.getType().equals(Account.Type.valueOf(type)));

        return searchBuilder.build();
    }

    //update accounts
    public Response updateAccount(Account account, String loginName, String password, String holderName, String status){

        if(account == null)
            return new Response(false, "Account Not Found");

        Login login = loginManager.get(u -> u.getUserId() == account.getUserId());

        if(loginName == null)
            return new Response(false, "The account exist, but no user has it...");

        if(!loginName.equals(""))
            login.setLogin(loginName);

        if(!password.equals(""))
            login.setPassword(password);

        if(!holderName.equals(""))
            account.setName(holderName);

        if(!status.equals(""))
            account.setStatus(Account.Status.valueOf(status));

        Response accountResponse = accountManager.update(account);
        Response loginResponse = loginManager.update(login);

        return new Response(accountResponse.isSuccess() && loginResponse.isSuccess(),
                            accountResponse.getMessage() + "\n" + loginResponse.getMessage());

    }

    //get amount report
    public Manager<Account> getAccountsBetweenAmount(double min, double max){
        SearchDecorator.Builder<Account> searchBuilder = new SearchDecorator.Builder<>(accountManager);

        searchBuilder.addQuery(u -> u.getBalance() >= min);
        searchBuilder.addQuery(u -> u.getBalance() <= max);

        return searchBuilder.build();
    }

    //get transactions report
    public Manager<Transaction> getAccountTransactionsBetween(int userId, Date min, Date max){

        SearchDecorator.Builder<Transaction> searchBuilder = new SearchDecorator.Builder<>(transferManager);

        searchBuilder.addQuery(u -> u.getUserId() == userId);
        searchBuilder.addQuery(u -> u.getDate().compareTo(min) >= 0);
        searchBuilder.addQuery(u -> u.getDate().compareTo(max) <= 0);

        return searchBuilder.build();
    }
}
