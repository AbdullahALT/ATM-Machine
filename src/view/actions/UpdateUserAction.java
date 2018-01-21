package view.actions;

import view.State;

import java.util.Scanner;

public class UpdateUserAction extends ActionScreen{

    public UpdateUserAction() {
        super("Update Account");
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
