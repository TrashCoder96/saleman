package ru.saleman.rest.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.saleman.manager.vo.AccountVo;
import ru.saleman.rest.ro.AccountRo;

/**
 * Created by Ivan Timofeev on 17.06.2018.
 */

@Component
public class AccountVoRoConverter extends AbstractConverter<AccountVo, AccountRo> {

    @Override
    protected AccountRo convert(AccountVo accountVo) {
        AccountRo accountRo = new AccountRo();
        accountRo.setId(accountVo.getId());
        accountRo.setUsername(accountVo.getUsername());
        return accountRo;
    }
}
