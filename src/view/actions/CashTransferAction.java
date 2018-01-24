package view.actions;

import controllers.Controller;
import model.Account;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class CashTransferAction extends ActionScreen {

    public CashTransferAction() {
        super("Cash Transfer");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {

        int accountId = Input.askForInteger("Enter the account number to which you want to transfer: ", scanner);
        double amount = Input.askForDouble("Enter amount in multiples of 500: ", scanner);

        while(amount % 500 != 0){
            amount = Input.askForDouble("The amount should be in multiples of 500, enter again: ", scanner);
        }

        Account holder = controller.getCustomerController().getAccount(accountId);

        if(holder != null){
            int confirm = Input.askForInteger("You wish to deposit Rs " + amount + " in account held by " + holder.getName()+ " ; If this "+
                    "information is correct please re-enter the account number: ", scanner);
            if(confirm != accountId)
                return;
        }

        Response response = controller.getCustomerController().transfer(amount, accountId);
        System.out.println(response.getMessage());

        if(response.isSuccess()){
            boolean printRecipe = Input.askForBoolean("Would you like to print a recipe?", scanner);

            if(printRecipe){
                controller.getCustomerController().displayBalance("Transferred: " + amount);
            }
        }
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
