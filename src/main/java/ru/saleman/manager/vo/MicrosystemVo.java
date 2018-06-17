package ru.saleman.manager.vo;

/**
 * Created by Ivan Timofeev on 17.06.2018.
 */
public class MicrosystemVo extends AbstractVo {

    private Long id;

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
