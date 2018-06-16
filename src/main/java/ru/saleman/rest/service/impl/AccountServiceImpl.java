package ru.saleman.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saleman.manager.AccountManager;
import ru.saleman.rest.ro.AccountRo;
import ru.saleman.rest.service.AccountService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

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
    public AccountRo create(String username, String password) {
        return modelMapper.map(accountManager.createAccountInMicrosystem(username, password), AccountRo.class);
    }

    @Override
    public void updateUsername(Long id, String username) {
        accountManager.updateAccount(id, username, null);
    }

    @Override
    public void updatePassword(Long id, String password) {
        accountManager.updateAccount(id, null, password);
    }

    @Override
    public void delete(Long id) {
        accountManager.deleteAccount(id);
    }

    @Override
    public AccountRo get(Long id) {
        return modelMapper.map(accountManager.getAccount(id), AccountRo.class);
    }

    @Override
    public List<AccountRo> getAll() {
        throw new NotImplementedException();
    }
}
