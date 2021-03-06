package controllers;

import manager.Manager;
import model.CurrentUser;
import model.Login;
import model.Response;

public class AuthenticationController {

    private Manager<Login> manager;

    public AuthenticationController(Manager<Login> manager){
        this.manager = manager;
    }

    public Response authenticate(String login, String password){

        Login user = manager.get(u -> u.getLogin().equals(login));

        if(user == null || !user.getPassword().equals(password))
            return new Response(false, "Either the login or the password is incorrect");

        CurrentUser.instance().set(user);

        return new Response(true, "Logged in.");
    }
}
