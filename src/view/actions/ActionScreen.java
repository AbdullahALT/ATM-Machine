package view.actions;

import controllers.Controller;
import view.Screen;
import view.State;

import java.util.Scanner;

/**
 * Action screens is a screen that will manipulate the data in some way using the controller
 */
public abstract class ActionScreen extends Screen {
    public ActionScreen(String title) {
        super(title);
    }

    @Override
    public void show(Scanner scanner, State state, Controller controller) {
        start(scanner, controller);
        finish(state);
    }

    /**
     * Interact with the user and start manipulating the data
     * @param scanner
     * @param controller
     */
    protected abstract void start(Scanner scanner, Controller controller);

    /**
     * Change the state according to the action when finished
     * @param state
     */
    protected abstract void finish(State state);
}
