package ru.saleman.rest.ro;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public class UpdateAccountRequestRo extends AbstractRo {

    private AccountRo account;

    public AccountRo getAccount() {
        return account;
    }

    public void setAccount(AccountRo account) {
        this.account = account;
    }
}
