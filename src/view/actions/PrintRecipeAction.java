package view.actions;

import controllers.Controller;
import view.State;

import java.util.Scanner;

public class PrintRecipeAction extends ActionScreen {

    public PrintRecipeAction() {
        super("Recipe");
    }

    @Override
    protected void invokeAction(Scanner scanner, Controller controller) {
        System.out.println("Coming Soon");
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
