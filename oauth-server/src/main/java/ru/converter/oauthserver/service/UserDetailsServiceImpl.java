package ru.converter.oauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.converter.oauthdb.repositories.UserRepo;
import ru.converter.oauthserver.principal.UserPrincipal;


@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepo.findByLogin(login)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("{AbstractUserDetailsAuthenticationProvider.badCredentials}"));
    }
}
