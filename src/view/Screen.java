package view;

import controllers.Controller;

import java.util.Scanner;

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
