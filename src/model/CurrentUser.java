package model;

public class CurrentUser {

    private static CurrentUser ourInstance = new CurrentUser();

    private Login currentUser;

    public static CurrentUser instance() {
        return ourInstance;
    }

    private CurrentUser() {
    }

    public Login get(){
        return currentUser;
    }

    public void set(Login currentUser) {
        this.currentUser = currentUser;
    }
}
