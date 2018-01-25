package manager;

import model.Account;
import model.Login;
import model.Transaction;

import java.util.List;

/**
 * Encapsulate the creation of the Managers objects, since the protection proxy needs
 * to be hidden from clients (They should never know that they actually interacting with a proxy, not the real Manager object)
 */
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
