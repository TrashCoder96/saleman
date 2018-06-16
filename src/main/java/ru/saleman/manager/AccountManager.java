package ru.saleman.manager;

import ru.saleman.manager.vo.AccountVo;

/**
 * Created by itimofeev on 12.06.2018.
 */
public interface AccountManager {

    AccountVo getAccount(Long id);

    AccountVo getAccount(String username);

    AccountVo createAccountInMicrosystem(String username, String password);

    AccountVo updateAccount(Long id, String username, String password);

    void deleteAccount(Long id);

    AccountVo getCurrentAccount();

}
