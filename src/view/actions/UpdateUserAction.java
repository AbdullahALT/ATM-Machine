package view.actions;

import controllers.Controller;
import controllers.manager.Response;
import model.Account;
import view.Input;
import view.State;

import java.util.Scanner;

public class UpdateUserAction extends ActionScreen{

    public UpdateUserAction() {
        super("Update Account");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {
        int accountId = Input.askForInteger("Enter the Account Number: ", scanner);

        Account account = controller.getCustomerController().getAccount(accountId);

        if(account == null){
            System.out.println("Account dose not exist.");
            return;
        }

        System.out.println(account);
        System.out.println("Please enter in the fields you wish to update (leave blank otherwise):");

        String login = Input.askForString("Login: ", scanner);
        String password = Input.askForString("Pin Code: ", scanner);
        String holderName = Input.askForString("Holder's Name: ", scanner);
        String status = Input.askForString("Status: ", scanner);

        Response response = controller.getAdminController().updateAccount(account, login, password, holderName, status);

        if(response.isSuccess())
            System.out.println("Your account has been successfully been updated.");
        else
            System.out.println(response.getMessage());
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
