package view.engine;

import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    public static int askForInteger(String message, @NotNull Scanner scanner){
        while(true) {
            try {

                String input = askForString(message, scanner);
                return Integer.parseInt(input);

            } catch (NumberFormatException e){
                System.out.println("You didn't type a number, try again.");
            }
        }
    }

    public static String askForString(String message, @NotNull Scanner scanner){
        while(true){
            try{

                System.out.print(message);
                return scanner.nextLine();

            } catch (NoSuchElementException e){
                System.out.println("You didn't enter a value, try again.");
            }
        }
    }
}
