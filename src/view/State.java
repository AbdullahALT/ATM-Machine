package view;

public class State {

    private Screen currentScreen;

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public void exit(){
        System.exit(0);
    }

    public void setCurrentScreen(Screen screen){
        this.currentScreen = screen;
    }


}
