package view;

import controllers.Controller;

import java.util.Scanner;

/**
 * The ATM machine, it will show the current screen and takes the controller
 * to give the action screens something to manipulate the data with.
 *
 */
public class Machine {

    private State state;

    public Machine(){
        this.state = new State();
    }

    public void run(Controller controller){
        Scanner scanner = new Scanner(System.in);

        while(!state.isHalt()){

            Screen screen = state.getCurrentScreen();

            try{
                System.out.println("=-=-=- " + screen.getTitle() + " -=-=-=");

                screen.show(scanner, state, controller);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
