package view.actions;

import controllers.Controller;
import controllers.manager.Manager;
import model.Account;
import model.Transaction;
import view.Input;
import view.State;

import java.util.Date;
import java.util.Scanner;

public class AccountsTransactionReportAction extends ActionScreen {

    public AccountsTransactionReportAction() {
        super("Date Report");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {

        int accountId = Input.askForInteger("Enter the account id: ", scanner);
        Date min = Input.askForDate("Enter the starting date: ", scanner);
        Date max = Input.askForDate("Enter the ending date: ", scanner);

        Account account = controller.getCustomerController().getAccount(accountId);

        if(account == null){
            System.out.println("Account does not exist");
            return;
        }

        Manager<Transaction> transactions = controller.adminController.getAccountTransactionsBetween(account.getUserId(), min, max);

        transactions.print();

    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
