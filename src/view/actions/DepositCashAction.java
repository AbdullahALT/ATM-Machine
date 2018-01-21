package view.actions;

import view.State;

import java.util.Scanner;

public class DepositCashAction extends ActionScreen {

    public DepositCashAction() {
        super("Deposit Cash");
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
