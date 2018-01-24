package view.actions;

import controllers.Controller;
import controllers.manager.Response;
import model.Account;
import model.Login;
import view.Input;
import view.State;

import java.util.Scanner;

public class CreateAccountAction extends ActionScreen {

    public CreateAccountAction() {
        super("Create Account");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {
        String login = Input.askForString("Login: ", scanner);
        String password = Input.askForString("Pin Code: ", scanner);
        String holderName = Input.askForString("Holder's Name: ", scanner);
        String type = Input.askForString("Type (Savings,Current): ", scanner);
        double amount = Input.askForDouble("Starting Balance: ", scanner);
        String status = Input.askForString("Status: ", scanner);

        Response response = controller.getAdminController().createUser(new Login(login, password), new Account(holderName, type, amount, status));

        System.out.println(response.getMessage());
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
