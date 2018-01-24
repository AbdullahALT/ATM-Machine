package view.actions;

import controllers.Controller;
import view.Screen;
import view.State;

import java.util.Scanner;

public abstract class ActionScreen extends Screen {
    public ActionScreen(String title) {
        super(title);
    }

    @Override
    public void show(Scanner scanner, State state, Controller controller) {
        invokeAction(scanner, controller);
        finish(state);
    }

    protected abstract void invokeAction(Scanner scanner, Controller controller);

    protected abstract void finish(State state);
}
