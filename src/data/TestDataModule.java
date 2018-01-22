package data;

import model.Account;
import model.Login;
import model.Transaction;

import java.util.Date;
import java.util.List;

public class TestDataModule {
    public static void main(String... args){

        Storage<String, List<Account>> accountFacade = StorageFactory.getAccountStorage("C:/Users/abaaltamimi/Desktop/Accounts.txt");

        List<Account> accounts = accountFacade.read();

        System.out.println("Account Current Content");
        accounts.forEach(account -> System.out.println(account.toString()));

        accounts.add(new Account(1, 1, "test", "test", 100.00, "asdk"));
        accounts.add(new Account(1, 1, "test", "test", 100.00, "asdk"));
        accounts.add(new Account(1, 1, "test", "test", 100.00, "asdk"));
        accounts.add(new Account(1, 1, "test", "test", 100.00, "asdk"));

        accountFacade.write(accounts);


        Storage<String, List<Login>> loginsFacade = StorageFactory.getLoginStorage("C:/Users/abaaltamimi/Desktop/Logins.txt");

        List<Login> logins = loginsFacade.read();

        System.out.println("Logins Current Content");
        logins.forEach(login -> System.out.println(logins.toString()));

        logins.add(new Login(1, "Test", "test"));
        logins.add(new Login(1, "Test", "test"));
        logins.add(new Login(1, "Test", "test"));
        logins.add(new Login(1, "Test", "test"));

        loginsFacade.write(logins);


        Storage<String, List<Transaction>> transferFacade = StorageFactory.getTransactionStorage("C:/Users/abaaltamimi/Desktop/Transfer.txt");

        List<Transaction> transfers = transferFacade.read();

        System.out.println("Transfers Current Content");
        transfers.forEach(transfer -> System.out.println(transfer.toString()));

        transfers.add(new Transaction(1, "", Transaction.Type.Withdraw, 10.5, new Date()));
        transfers.add(new Transaction(1, "", Transaction.Type.Withdraw,10.5, new Date()));
        transfers.add(new Transaction(1, "", Transaction.Type.Withdraw,10.5, new Date()));
        transfers.add(new Transaction(1, "", Transaction.Type.Withdraw,10.5, new Date()));

        transferFacade.write(transfers);
    }
}
