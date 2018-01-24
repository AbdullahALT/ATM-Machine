package view;

import controllers.Controller;

import java.util.Scanner;

public class Machine {

    private State state;
    private boolean halt;

    public Machine(){
        this.state = new State();
        this.halt = false;
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

    public void halt(){
        this.halt = true;
    }
}
