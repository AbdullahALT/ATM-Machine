package view.actions;

import controllers.Controller;
import model.Account;
import view.Input;
import view.State;

import java.util.Scanner;

public class SearchAccountAction extends ActionScreen {
    public SearchAccountAction() {
        super("Search Account");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {

        int accountId = Input.askForIntegerWithDefault("Account ID: ", scanner, -1);
        int userId = Input.askForIntegerWithDefault("User ID: ", scanner, -1);
        String holderName = Input.askForString("Holders Name: ", scanner);
        String type = Input.askForString("Type: ", scanner);
        double balance = Input.askForDoubleWithDefault("Balance: ", scanner, -1);
        String status = Input.askForString("Status: ", scanner);

        controller.getAdminController().searchAccounts(new Account(userId, accountId, holderName, type, balance, status )).print();

    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
