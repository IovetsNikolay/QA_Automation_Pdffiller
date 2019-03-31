package lesson1.HomeWork.model;

public class DataFields {
    private final String login;
    private final String password;

    public DataFields(String login, String password) {
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
