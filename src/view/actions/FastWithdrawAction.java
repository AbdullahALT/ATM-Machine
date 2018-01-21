package view.actions;

import view.State;

import java.util.Scanner;

public class FastWithdrawAction extends ActionScreen{


    public FastWithdrawAction() {
        super("Fast Withdraw");
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
