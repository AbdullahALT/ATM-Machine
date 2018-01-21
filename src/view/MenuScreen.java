package view;

import model.MenuItem;

import java.util.List;
import java.util.Scanner;

public abstract class MenuScreen extends Screen{

    private List<MenuItem> menuItems;

    public MenuScreen(String title) {
        super(title);
        this.menuItems = initItems();
    }

    @Override
    public void show(Scanner scanner, State state) throws EmptyMenuScreenException{
        if(menuItems == null || menuItems.size() == 0)
            throw new EmptyMenuScreenException("Menu items list is either null or has no items. make sure to initiate items using initItems() method");

        printList(menuItems);

        chooseItem(state);
    }

    private void chooseItem(State state) {
        while(true){

            int choice = 0;

            try{
                menuItems.get(choice).getOnChoseListener().OnChose();
                return;
            } catch (IndexOutOfBoundsException e){
                System.out.println("There is no item with the number " + choice + ", please try again.");
            }
        }
    }

    private void printList(List<MenuItem> menuItems) {
        System.out.println("Choose one of the following");

        for(int i = 1; i < menuItems.size(); i++){
            System.out.println( i + "- " + menuItems.get(i - 1).getLabel());
        }

        System.out.println("Choice: ");
    }

    protected abstract List<MenuItem> initItems();

    private class EmptyMenuScreenException extends Exception {
        public EmptyMenuScreenException(String message) {
            super(message);
        }

        public EmptyMenuScreenException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
