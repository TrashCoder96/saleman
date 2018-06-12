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
import ru.saleman.util.SalemanConstants;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    public AccountVo getAccount(String username) {
        return modelMapper.map(credentialsRepository.findCredentialsDtoByUsername(username), AccountVo.class);
    }

    @Override
    @Transactional
    public AccountVo createAccountInMicrosystem(String username, String password) {
        MicrosystemDto microsystem = microsystemRepository.getMicrosystemByAdminCredentialsId(getCurrentAccount().getId());
        CredentialsDto credentialsDto = new CredentialsDto();
        credentialsDto.setUsername(username);
        credentialsDto.setPassword(password);
        credentialsDto.setRole(roleRepository.getOne(SalemanConstants.Role.USER));
        microsystem.setAdmin(credentialsDto);
        credentialsDto = credentialsRepository.save(credentialsDto);
        microsystemRepository.save(microsystem);
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


}
