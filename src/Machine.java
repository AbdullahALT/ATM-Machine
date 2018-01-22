
import view.Screen;
import view.State;

import java.util.Scanner;

public class Machine {

    private State state;

    public Machine(){
        this.state = new State();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        while(true){

            Screen screen = state.getCurrentScreen();

            try{
                System.out.println("=-=-=- " + screen.getTitle() + " -=-=-=");

                screen.show(scanner, state);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
