package view.actions;

import controllers.Controller;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class NormalWithdrawAction extends ActionScreen {

    public NormalWithdrawAction() {
        super("Normal Withdraw");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {

        double amount = Input.askForDouble("Enter the withdrawal amount: ", scanner);

        Response response = controller.getCustomerController().withdraw(amount);

        if(!response.isSuccess()) {
            System.out.println(response.getMessage());
            return;
        }

        boolean printRecipe = Input.askForBoolean("Would you like to print a recipe?", scanner);

        if(printRecipe){
            controller.getCustomerController().displayBalance("Withdrawn: " + amount);
        }

        System.out.println("Cash Successfully Withdrawn!");
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
