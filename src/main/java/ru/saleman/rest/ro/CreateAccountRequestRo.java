package ru.saleman.rest.ro;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
public class CreateAccountRequestRo extends AbstractRo {

    private AccountRo newAccount;

    public AccountRo getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(AccountRo newAccount) {
        this.newAccount = newAccount;
    }

}
