package ru.saleman.rest.service;

import ru.saleman.rest.ro.AccountRo;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public interface AccountService {

    void create(AccountRo account);

    void update(AccountRo account);

    void delete(Long id);

    AccountRo get(Long id);

    List<AccountRo> getAll();

}
