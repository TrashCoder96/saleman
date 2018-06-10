package ru.saleman.rest.ro;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public class GetAllAccountsResponseRo extends AbstractRo {

    private List<AccountRo> accounts;

    public List<AccountRo> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountRo> accounts) {
        this.accounts = accounts;
    }
}
