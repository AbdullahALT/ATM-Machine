package model;

public class Login {

    private String userId;
    private String login;
    private String password;

    public Login(String userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
