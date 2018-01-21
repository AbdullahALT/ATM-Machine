package view.actions;

import view.State;
import view.engine.Input;

import java.util.Scanner;

public class LoginAction extends ActionScreen {

    private boolean isAdmin;

    public LoginAction() {
        super("Login");
    }

    @Override
    protected void invokeAction(Scanner scanner) {
        String login = Input.askForString("Login: ", scanner);
        String password = Input.askForString("Password: ", scanner);

        //TODO: Authenticate user here.

        isAdmin = login.equals("admin");
    }

    @Override
    protected void finish(State state) {
       if(isAdmin) {
           state.setCurrentScreen(state.getAdminMenu());
       } else {
           state.setCurrentScreen(state.getCustomerMenu());
       }
    }
}
