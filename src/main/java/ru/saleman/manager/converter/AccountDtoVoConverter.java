package ru.saleman.manager.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ru.saleman.data.dto.CredentialsDto;
import ru.saleman.manager.vo.AccountVo;

/**
 * Created by Ivan Timofeev on 17.06.2018.
 */
@Component
public class AccountDtoVoConverter extends AbstractConverter<CredentialsDto, AccountVo> {

    @Override
    protected AccountVo convert(CredentialsDto credentialsDto) {
        String roleName = credentialsDto.getRole().getName();
        AccountVo accountVo = new AccountVo();
        accountVo.setId(credentialsDto.getId());
        accountVo.setPassword(credentialsDto.getPassword());
        accountVo.setUsername(credentialsDto.getUsername());
        GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
        accountVo.getAuthorities().add(authority);
        accountVo.setId(credentialsDto.getId());
        return accountVo;
    }
}
