package com.ski.skiresort.security.service;

import com.ski.skiresort.security.domain.Role;
import com.ski.skiresort.security.domain.User;
import org.hibernate.annotations.Immutable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.ski.skiresort.security.domain.Role.USER;


@Service
public class UserService implements UserDetailsService {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                    .username(username)
                    .password("{noop}password")
                    .authorities(Collections.singletonList(USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();

    }
}
