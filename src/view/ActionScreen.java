package view;

import java.util.Scanner;

public abstract class ActionScreen extends Screen{
    public ActionScreen(String title) {
        super(title);
    }

    @Override
    public void show(Scanner scanner, State state) {
        invokeAction(scanner);
        finish(state);
    }

    protected abstract void invokeAction(Scanner scanner);

    protected abstract void finish(State state);
}
