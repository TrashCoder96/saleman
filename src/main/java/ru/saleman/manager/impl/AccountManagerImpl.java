package ru.saleman.manager.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.saleman.data.CredentialsRepository;
import ru.saleman.data.MicrosystemRepository;
import ru.saleman.data.RoleRepository;
import ru.saleman.data.dto.CredentialsDto;
import ru.saleman.data.dto.MicrosystemDto;
import ru.saleman.manager.AccountManager;
import ru.saleman.manager.vo.AccountVo;
import ru.saleman.manager.vo.MicrosystemVo;
import ru.saleman.util.SalemanConstants;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by itimofeev on 12.06.2018.
 */
@Component
public class AccountManagerImpl implements AccountManager {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private MicrosystemRepository microsystemRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true)
    public AccountVo getAccount(Long id) {
        return modelMapper.map(credentialsRepository.getOne(id), AccountVo.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountVo getAccount(String username) {
        return modelMapper.map(credentialsRepository.findCredentialsDtoByUsername(username), AccountVo.class);
    }

    @Override
    @Transactional
    public AccountVo createAccountInMicrosystem(String username, String password, Long microsystemId) {
        MicrosystemDto microsystem = microsystemRepository.getOne(microsystemId);
        CredentialsDto credentialsDto = new CredentialsDto();
        credentialsDto.setUsername(username);
        credentialsDto.setPassword(password);
        credentialsDto.setRole(roleRepository.getOne(SalemanConstants.Role.OPERATOR));
        credentialsDto.setMicrosystem(microsystem);
        credentialsDto.setAdmin(false);
        credentialsDto = credentialsRepository.save(credentialsDto);
        return modelMapper.map(credentialsDto, AccountVo.class);
    }

    @Override
    @Transactional
    public AccountVo updateAccount(Long id, String username, String password) {
        throw new NotImplementedException();
    }

    @Override
    @Transactional
    public void deleteAccount(Long id) {
        credentialsRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountVo getCurrentAccount() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        return getAccount(authentication.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountVo> getAccountsByMicrosystem(Long microsystemId) {
        return credentialsRepository
                .findCredentialsDtosByMicrosystemId(microsystemId)
                .stream()
                .map(cd -> modelMapper.map(cd, AccountVo.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MicrosystemVo getMicrosystemByAccountId(Long accountId) {
        return modelMapper.map(microsystemRepository.getMicrosystemByCredentialsId(accountId), MicrosystemVo.class);
    }


}
