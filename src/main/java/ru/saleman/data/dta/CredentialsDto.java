package ru.saleman.data.dta;

import javax.persistence.*;

/**
 * Created by Ivan Timofeev on 21.04.2018.
 */
@Entity
@Table(name = "CREDENTIALS_DTO")
public class CredentialsDto {

    @Id
    private String username;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private RoleDto role;

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

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }
}
