package ru.saleman.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saleman.manager.AccountManager;
import ru.saleman.manager.vo.MicrosystemVo;
import ru.saleman.rest.ro.AccountRo;
import ru.saleman.rest.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AccountRo create(String username, String password) {
        MicrosystemVo microsystemVo = accountManager.getMicrosystemByAccountId(accountManager.getCurrentAccount().getId());
        return modelMapper.map(accountManager.createAccountInMicrosystem(username, password, microsystemVo.getId()), AccountRo.class);
    }

    @Override
    @Transactional
    public void updateUsername(Long id, String username) {
        accountManager.updateAccount(id, username, null);
    }

    @Override
    @Transactional
    public void updatePassword(Long id, String password) {
        accountManager.updateAccount(id, null, password);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        accountManager.deleteAccount(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountRo get(Long id) {
        return modelMapper.map(accountManager.getAccount(id), AccountRo.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountRo> getAll() {
        MicrosystemVo microsystemVo = accountManager.getMicrosystemByAccountId(accountManager.getCurrentAccount().getId());
        return accountManager.getAccountsByMicrosystem(microsystemVo.getId())
                .stream()
                .map(accountVo -> modelMapper.map(accountVo, AccountRo.class))
                .collect(Collectors.toList());
    }

}
