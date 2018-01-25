package application;

import controllers.AdminController;
import controllers.AuthenticationController;
import controllers.Controller;
import controllers.CustomerController;
import manager.Manager;
import manager.ManagerFactory;
import model.Account;
import model.CurrentUser;
import model.Login;
import model.Transaction;
import storage.Storage;
import storage.StorageFactory;
import view.Machine;

import java.util.List;

public class Main {

    static String accountsSource = "resources/Accounts.atmres";
    static String loginsSource = "resources/Logins.atmres";
    static String transactionsSource = "resources/Transactions.atmres";

    public static void main(String... args){

        // Open storages for reading and writing
        Storage<String, List<Account>> accountStorage = StorageFactory.getAccountStorage(Main.accountsSource);
        Storage<String, List<Login>> loginStorage = StorageFactory.getLoginStorage(Main.loginsSource);
        Storage<String, List<Transaction>> transactionStorage = StorageFactory.getTransactionStorage(Main.transactionsSource);

        // Take the data to managers for easy and fast manipulations
        Manager<Account> accountManager = ManagerFactory.getAccountManager(accountStorage.read());
        Manager<Login> loginManager = ManagerFactory.getLoginManager(loginStorage.read());
        Manager<Transaction> transactionManager = ManagerFactory.getTransactionManager(transactionStorage.read());

        if(accountManager.getList().size() == 0 || loginManager.getList().size() == 0)
            SeedStorage(accountStorage, loginStorage, accountManager, loginManager);

        // Give the managers to the controllers to strict access to managers and give specific actions
        AdminController adminController = new AdminController(accountManager, transactionManager, loginManager);
        CustomerController customerController = new CustomerController(accountManager, transactionManager);
        AuthenticationController authenticationController = new AuthenticationController(loginManager);

        // Run the ATM Machine
        Machine machine = new Machine();
        Controller controller = new Controller(adminController, customerController, authenticationController);
        machine.run(controller);

        // Write back to the permanent storages before the application stops
        accountStorage.write(accountManager.getList());
        loginStorage.write(loginManager.getList());
        transactionStorage.write(transactionManager.getList());
    }

    static void SeedStorage(Storage<String, List<Account>> accountStorage,
                            Storage<String, List<Login>> loginStorage,
                            Manager<Account> accountManager,
                            Manager<Login> loginManager){

        //A current user of admin needed to create users
        CurrentUser.instance().set(new Login("admin", null));

        //for now, just seed the admin
        accountManager.insert(new Account("admin", Account.Type.Current, 1000.0, Account.Status.Active));
        loginManager.insert(new Login("admin", "admin"));
        accountStorage.write(accountManager.getList());
        loginStorage.write(loginManager.getList());

        //Reset the current user
        CurrentUser.instance().set(null);
    }

}
