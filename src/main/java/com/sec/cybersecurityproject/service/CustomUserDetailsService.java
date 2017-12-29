package com.sec.cybersecurityproject.service;

import com.sec.cybersecurityproject.model.Account;
import com.sec.cybersecurityproject.repository.AccountRepository;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepo.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("No user found");
        }
        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER"))
        );
    }

}
