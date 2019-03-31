package lesson1.HomeWork.model;

public class UserDataFields {
    private final String login;
    private final String password;



    public UserDataFields(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
