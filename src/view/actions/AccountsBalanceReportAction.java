package view.actions;

import controllers.Controller;
import controllers.manager.Manager;
import model.Account;
import view.Input;
import view.State;

import java.util.Scanner;

public class AccountsBalanceReportAction extends ActionScreen {

    public AccountsBalanceReportAction() {
        super("Balance Report");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {
        double min = Input.askForDouble("Enter the minimum amount: ", scanner);
        double max = Input.askForDouble("Enter the maximum amount: ", scanner);

        Manager<Account> accounts = controller.getAdminController().getAccountsBetweenAmount(min, max);

        if(accounts == null){
            System.out.println("No accounts match your criteria ");
            return;
        }

        accounts.print();
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
