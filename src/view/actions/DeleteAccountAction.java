package view.actions;

import controllers.Controller;
import controllers.manager.Response;
import model.Account;
import view.Input;
import view.State;

import java.util.Scanner;

public class DeleteAccountAction extends ActionScreen {

    public DeleteAccountAction() {
        super("Delete Account");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {
        int accountId = Input.askForInteger("Enter the account number to which you want to delete: ", scanner);

        Account account = controller.getCustomerController().getAccount(accountId);

        if(account == null){
            System.out.println("User not found");
            return;
        }

        int confirm = Input.askForInteger("You wish to delete the account held by "+account.getName()+"; If this information is correct please re-enter the account number: ", scanner);

        if(confirm != accountId){
            System.out.println("Operation Canceled.");
            return;
        }

        Response response = controller.getAdminController().deleteUser(account);
        System.out.println(response.getMessage());
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
