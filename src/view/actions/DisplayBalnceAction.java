package view.actions;

import controllers.Controller;
import view.State;

import java.util.Scanner;

public class DisplayBalnceAction extends ActionScreen {

    public DisplayBalnceAction() {
        super("Display Balance");
    }

    @Override
    protected void start(Scanner scanner, Controller controller) {
        controller.getCustomerController().displayBalance();
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
