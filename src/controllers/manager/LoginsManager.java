package controllers.manager;

import model.Login;
import storage.Storage;

import java.util.List;

public class LoginsManager extends DataManager<Login> {

    private Storage<String, List<Login>> storage;

    public LoginsManager(List<Login> list) {
        super(list);
    }

    @Override
    public Response insert(Login data) {
        data.setUserId(newID());

        //The account id should not be already exist
        if(get(user -> user.getLogin().equals(data.getLogin())) != null)
            return new Response(false, "Please choose another login name");

        return super.insert(data);
    }

    @Override
    public Response update(Login updated) {

        getList().replaceAll(login -> {
            if(login.getUserId() == updated.getUserId()){

                login.setLogin(updated.getLogin());
                login.setPassword(updated.getPassword());

            }

            return login;
        });

        return new Response(true, "Your login credentials have been updated");
    }

    @Override
    public void print() {
        System.out.printf("%-20s%s%n", "", "=-=-=-=-= Login Table =-=-=-=-=");
        System.out.printf("%-20s%-20s%s%n", "User ID", "Login", "Password");
        getList().forEach(login -> {
            System.out.printf("%-20s%-20s%-20s%n", login.getUserId(), login.getLogin(), login.getPassword());
        });
    }

    @Override
    public Manager<Login> hold(List<Login> list) {
        return new LoginsManager(list);
    }

    private int newID() {
        if(getList().size() == 0)
            return 1;

        Login last = getList().get(getList().size() - 1);

        int index = last.getUserId() + 1;
        return last.getUserId() + 1;
    }

}
