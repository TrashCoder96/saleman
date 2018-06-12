package ru.saleman.data.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ivan Timofeev on 21.04.2018.
 */
@Entity
@Table(name="ROLE_DTO")
public class RoleDto extends AbstractDto {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
