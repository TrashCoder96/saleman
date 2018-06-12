package ru.saleman.rest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ru.saleman.rest.service.LoginService;
import ru.saleman.security.JwtTokenRo;
import ru.saleman.security.JwtTokenUtil;

/**
 * Created by Ivan Timofeev on 10.05.2018.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthenticationRestController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestParam String username,
                                                       @RequestParam String password) throws AuthenticationException {

        JwtTokenRo jwtTokenRo = new JwtTokenRo();
        jwtTokenRo.setToken(loginService.login(username, password));
        return ResponseEntity.ok(jwtTokenRo);
    }

}
