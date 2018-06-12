package ru.saleman.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.saleman.manager.AccountManager;
import ru.saleman.manager.vo.AccountVo;

import javax.transaction.Transactional;

/**
 * Created by asus-pc on 18.11.2017.
 */
@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountManager accountManager;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountVo user = accountManager.getAccount(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        return user;
    }
}
