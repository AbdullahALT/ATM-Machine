package controllers.manager;

import model.Account;
import model.Login;
import model.Transaction;

import java.util.List;

public class ManagerFactory {

    public static Manager<Account> getAccountManager(List<Account> accounts){
        return new UserProxy<>(new AccountsManager(accounts));
    }

    public static Manager<Login> getLoginManager(List<Login> logins){
        return new UserProxy<>(new LoginsManager(logins));
    }

    public static Manager<Transaction> getTransactionManager(List<Transaction> transactions){
        return new TransactionManager(transactions);
    }
}
