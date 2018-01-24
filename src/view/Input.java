package view;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    public static boolean askForBoolean(String message, @NotNull Scanner scanner){
        while(true) {
                String input = askForString(message + " (y/n) ", scanner);

                if(input.toLowerCase().equals("y"))
                    return true;
                if(input.toLowerCase().equals("n"))
                    return false;

                System.out.println("please choose either y for yes or n for no");
        }
    }

    public static double askForDoubleWithDefault(String message, @NotNull Scanner scanner, double defaultValue){
        while(true) {
            String input = askForStringWithDefault(message, scanner, String.valueOf(defaultValue));

            try {
                return Double.parseDouble(input);

            } catch (NumberFormatException e){
                System.out.println("You didn't type a number, try again.");
            }
        }
    }

    public static double askForDouble(String message, @NotNull Scanner scanner){
        while(true) {
            String input = askForString(message, scanner);

            try {
                return Double.parseDouble(input);

            } catch (NumberFormatException e){
                System.out.println("You didn't type a number, try again.");
            }
        }
    }

    public static int askForIntegerWithDefault(String message, @NotNull Scanner scanner, int defaultValue){
        while(true) {

            String input = askForStringWithDefault(message, scanner, String.valueOf(defaultValue));

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e){
                System.out.println("You didn't type a number, try again.");
            }
        }
    }

    public static int askForInteger(String message, @NotNull Scanner scanner){
        while(true) {

            String input = askForString(message, scanner);

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e){
                System.out.println("You didn't type a number, try again.");
            }
        }
    }

    public static Date askForDate(String message, @NotNull Scanner scanner){
        while(true){
            String input = askForString(message, scanner);

            try {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.parse(input);

            } catch (ParseException e){
                System.out.println("You didn't type a valid date, dates should be of the form dd/MM/yyyy");
            }
        }
    }

    public static String askForSpecificString(String message, @NotNull Scanner scanner, String[] values){
        while (true){
            String input = askForString(message, scanner);

            for(String value : values){
                if(value.toLowerCase().equals(input.toLowerCase())){
                    return value;
                }
            }

            System.out.println("You didn't type a valid value");
        }
    }

    public static String askForSpecificStringWithDefault(String message, @NotNull Scanner scanner, String[] values, String defautValue){
        while (true){
            String input = askForString(message, scanner);

            if(input.equals(""))
                return defautValue;

            for(String value : values){
                if(value.toLowerCase().equals(input.toLowerCase())){
                    return value;
                }
            }

            System.out.println("You didn't type a valid value");
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

    public static String askForStringWithDefault(String message, @NotNull Scanner scanner, String defaultValue){
        while(true){
            try{

                System.out.print(message);

                String input = scanner.nextLine();

                return (input.equals(""))? defaultValue : input;

            } catch (NoSuchElementException e){
                System.out.println("You didn't enter a value, try again.");
            }
        }
    }

}
