package view;

import controllers.AdminController;
import controllers.AuthenticationController;
import controllers.Controller;
import controllers.CustomerController;
import controllers.manager.Manager;
import controllers.manager.ManagerFactory;
import model.Account;
import model.Login;
import model.Transaction;
import storage.Storage;
import storage.StorageFactory;

import java.util.List;

public class Main {

    static String accountsSource = "C:/Users/abaaltamimi/Desktop/Accounts.txt";
    static String loginsSource = "C:/Users/abaaltamimi/Desktop/Logins.txt";
    static String transactionsSource = "C:/Users/abaaltamimi/Desktop/Transfer.txt";

    public static void main(String... args){

        // Open storages for reading and writing
        Storage<String, List<Account>> accountStorage = StorageFactory.getAccountStorage(Main.accountsSource);
        Storage<String, List<Login>> loginStorage = StorageFactory.getLoginStorage(Main.loginsSource);
        Storage<String, List<Transaction>> transactionStorage = StorageFactory.getTransactionStorage(Main.transactionsSource);

        // Take the data to managers for easy and fast manipulations
        Manager<Account> accountManager = ManagerFactory.getAccountManager(accountStorage.read());
        Manager<Login> loginManager = ManagerFactory.getLoginManager(loginStorage.read());
        Manager<Transaction> transactionManager = ManagerFactory.getTransactionManager(transactionStorage.read());

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

}
