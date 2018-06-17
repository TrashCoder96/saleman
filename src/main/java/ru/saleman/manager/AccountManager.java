package ru.saleman.manager;

import ru.saleman.manager.vo.AccountVo;
import ru.saleman.manager.vo.MicrosystemVo;

import java.util.List;

/**
 * Created by itimofeev on 12.06.2018.
 */
public interface AccountManager {

    AccountVo getAccount(Long id);

    AccountVo getAccount(String username);

    AccountVo createAccountInMicrosystem(String username, String password, Long microsystemId);

    AccountVo updateAccount(Long id, String username, String password);

    void deleteAccount(Long id);

    AccountVo getCurrentAccount();

    List<AccountVo> getAccountsByMicrosystem(Long microsystemId);

    MicrosystemVo getMicrosystemByAccountId(Long accountId);

}
