package ru.saleman.security;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by asus-pc on 18.11.2017.
 */
@Component
public class TimeProvider {

    private static final long serialVersionUID = -3301695478208950415L;

    public Date now() {
        return new Date();
    }

}
