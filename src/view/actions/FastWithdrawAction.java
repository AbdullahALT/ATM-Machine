package view.actions;

import controllers.Controller;
import model.Response;
import view.Input;
import view.State;

import java.util.Scanner;

public class FastWithdrawAction extends ActionScreen{


    public FastWithdrawAction() {
        super("Fast Withdraw");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {
        System.out.println("1----500");
        System.out.println("2----1000");
        System.out.println("3----2000");
        System.out.println("4----5000");
        System.out.println("5----10000");
        System.out.println("6----15000");
        System.out.println("7----20000");

        boolean loop = true;
        double amount = 0;
        while(loop){
            int choice = Input.askForInteger("Select one of the denominations of money: ", scanner);

            switch (choice){
                case 1:
                    amount = 500;
                    loop = false;
                    break;
                case 2:
                    amount = 1000;
                    loop = false;
                    break;
                case 3:
                    amount = 2000;
                    loop = false;
                    break;
                case 4:
                    amount = 5000;
                    loop = false;
                    break;
                case 5:
                    amount = 10000;
                    loop = false;
                    break;
                case 6:
                    amount = 15000;
                    loop = false;
                    break;
                case 7:
                    amount = 20000;
                    loop = false;
                    break;
                    default: System.out.println("Your choice is not recognized");
            }
        }

        boolean confirm = Input.askForBoolean("Are you sure you want to withdraw Rs" + amount, scanner);

        if(!confirm)
            return;

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
