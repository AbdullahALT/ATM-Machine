package view.actions;

import view.State;

import java.util.Scanner;

public class BalanceReportAction extends ActionScreen {

    public BalanceReportAction() {
        super("Balance Report");
    }

    @Override
    protected void invokeAction(Scanner scanner) {
        System.out.println("Coming Soon");
    }

    @Override
    protected void finish(State state) {
        state.setCurrentScreen(state.getAdminMenu());
    }
}
