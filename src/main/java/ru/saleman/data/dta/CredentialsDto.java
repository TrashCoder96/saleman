package ru.saleman.data.dta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by asus-pc on 21.04.2018.
 */
@Entity
public class CredentialsDto {

    @Id
    private String username;

    @Column
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
