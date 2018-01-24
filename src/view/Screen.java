package view;

import controllers.Controller;

import java.util.Scanner;

/**
 * Anything that appears in the console screen, its a simulation of views in web design
 */
public abstract class Screen {

    private String title;

    public Screen(String title) {
        this.title = title;
    }

    public final String getTitle() {
        return title;
    }

    public abstract void show(Scanner scanner, State state, Controller controller) throws Exception;
}
