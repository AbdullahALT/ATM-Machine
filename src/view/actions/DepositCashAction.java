package view.actions;

import controllers.Controller;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class DepositCashAction extends ActionScreen {

    public DepositCashAction() {
        super("Deposit Cash");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {

        double amount = Input.askForDouble("Enter the cash amount to deposit: ", scanner);

        Response response = controller.getCustomerController().deposit(amount);

        if(response.isSuccess()) {

            System.out.println("Cash Deposited Successfully.");
            boolean printRecipe = Input.askForBoolean("Would you like to print a recipe?", scanner);

            if(printRecipe){
                controller.getCustomerController().displayBalance("Deposited: " + amount);
            }

        }
        else
            System.out.println(response.getMessage());
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
