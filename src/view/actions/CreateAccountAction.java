package view.actions;

import controllers.Controller;
import model.Account;
import model.Login;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class CreateAccountAction extends ActionScreen {

    public CreateAccountAction() {
        super("Create Account");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {
        String login = Input.askForString("Login: ", scanner);
        String password = Input.askForString("Pin Code: ", scanner);
        String holderName = Input.askForString("Holder's Name: ", scanner);
        String type = Input.askForSpecificString("Type (Savings,Current): ", scanner, Account.getTypes());
        double amount = Input.askForDouble("Starting Balance: ", scanner);
        String status = Input.askForSpecificString("Status: ", scanner, Account.getStatuses());

        Response response = controller.getAdminController().createUser(new Login(login, password), new Account(holderName, Account.Type.valueOf(type), amount, Account.Status.valueOf(status)));

        System.out.println(response.getMessage());
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
