package view.actions;

import controllers.Controller;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class LoginAction extends ActionScreen {

    private boolean isAdmin;

    public LoginAction() {
        super("Login");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {
        boolean loop = true;
        while(loop) {
            String login = Input.askForString("Login: ", scanner);
            String password = Input.askForString("Password: ", scanner);

            //TODO: Authenticate user here.
            Response response = controller.getAuthenticationController().authenticate(login, password);
            loop = !response.isSuccess();

            System.out.println(response.getMessage());

            isAdmin = login.equals("admin");
        }
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
