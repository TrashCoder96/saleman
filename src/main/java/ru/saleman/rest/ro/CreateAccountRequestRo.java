package ru.saleman.rest.ro;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public class CreateAccountRequestRo extends AbstractRo {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
