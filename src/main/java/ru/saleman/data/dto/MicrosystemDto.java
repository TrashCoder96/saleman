package ru.saleman.data.dto;

import javax.persistence.*;

/**
 * Created by itimofeev on 12.06.2018.
 */
@Entity
@Table(name = "MICROSYSTEM_DTO")
public class MicrosystemDto extends AbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
