package ru.saleman.rest.ro;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public class GetAllAccountsRequestRo extends AbstactRo {

    private Integer count;

    private List<AccountRo> accounts;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<AccountRo> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountRo> accounts) {
        this.accounts = accounts;
    }
}
