package ru.saleman.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saleman.data.dta.CredentialsDto;
import ru.saleman.rest.ro.AccountRo;
import ru.saleman.rest.service.AccountService;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(AccountRo account) {
        CredentialsDto credentialsDto = modelMapper.map(account, CredentialsDto.class);
    }

    @Override
    public void update(AccountRo account) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AccountRo get(Long id) {
        return null;
    }

    @Override
    public List<AccountRo> getAll() {
        return null;
    }
}
