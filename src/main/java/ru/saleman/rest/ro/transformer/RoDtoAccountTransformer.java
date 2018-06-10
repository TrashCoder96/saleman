package ru.saleman.rest.ro.transformer;

import org.springframework.stereotype.Component;
import ru.saleman.data.dta.CredentialsDto;
import ru.saleman.rest.ro.AccountRo;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Component
public class RoDtoAccountTransformer extends RoDtoAbstractTransformer<AccountRo, CredentialsDto> {

    @Override
    AccountRo toRo(CredentialsDto dto) {
        return null;
    }

    @Override
    CredentialsDto toDto(AccountRo ro) {
        CredentialsDto dto = new CredentialsDto();
        dto.setUsername(ro.getEmail());
        dto.setPassword(ro.getPassword());
        return dto;
    }

    @Override
    AccountRo createRo() {
        return new AccountRo();
    }

    @Override
    CredentialsDto createDto() {
        return new CredentialsDto();
    }
}
