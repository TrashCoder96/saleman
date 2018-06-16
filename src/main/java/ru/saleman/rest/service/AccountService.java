package ru.saleman.rest.service;

import ru.saleman.rest.ro.AccountRo;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public interface AccountService {

    AccountRo create(String username, String password);

    void updateUsername(Long id, String username);

    void updatePassword(Long id, String password);

    void delete(Long id);

    AccountRo get(Long id);

    List<AccountRo> getAll();

}
