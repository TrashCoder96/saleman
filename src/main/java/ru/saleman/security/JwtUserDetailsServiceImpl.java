package ru.saleman.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.saleman.data.CredentialsRepository;
import ru.saleman.data.dta.CredentialsDto;

import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * Created by asus-pc on 18.11.2017.
 */
@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDto credentialsDto = credentialsRepository.findById(username).get();
        if (credentialsDto == null)
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        JwtUserDetails userDetails = new JwtUserDetails(credentialsDto.getUsername(), credentialsDto.getPassword(), Arrays.asList(new  SimpleGrantedAuthority("ROLE_USER")));
        return userDetails;
    }
}
