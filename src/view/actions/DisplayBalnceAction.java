package view.actions;

import view.State;

import java.util.Scanner;

public class DisplayBalnceAction extends ActionScreen {

    public DisplayBalnceAction() {
        super("Display Balance");
    }

    @Override
    protected void invokeAction(Scanner scanner) {
        System.out.println("Coming Soon");
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getCustomerMenu());
    }
}
