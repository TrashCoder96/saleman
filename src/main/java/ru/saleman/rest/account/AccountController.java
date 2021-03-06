package ru.saleman.rest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.saleman.rest.ro.*;
import ru.saleman.rest.service.AccountService;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public CreateAccountResponseRo createAccount(@RequestBody CreateAccountRequestRo request) {
        AccountRo account = accountService.create(request.getUsername(), request.getPassword());
        CreateAccountResponseRo response = new CreateAccountResponseRo();
        response.setId(account.getId());
        return response;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public UpdateAccountResponseRo updateAccount(@RequestBody UpdateAccountRequestRo request) {
        return null;
    }

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public DeleteAccountResponseRo deleteAccount(@RequestParam("id") Long id) {
        accountService.delete(id);
        return new DeleteAccountResponseRo();
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public GetAllAccountsResponseRo allAccountsRequestRo() {
        GetAllAccountsResponseRo responseRo = new GetAllAccountsResponseRo();
        responseRo.setAccounts(accountService.getAll());
        return responseRo;
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public GetAccountResponseRo getAccount(@PathVariable("id") Long id) {
        GetAccountResponseRo response = new GetAccountResponseRo();
        response.setAccount(accountService.get(id));
        return response;
    }

}
