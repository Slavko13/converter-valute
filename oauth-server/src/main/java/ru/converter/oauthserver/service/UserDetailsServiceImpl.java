package ru.converter.oauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.oauthdb.domains.user.User;
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
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(login).get();

        return userRepo.findByLogin(login)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("{AbstractUserDetailsAuthenticationProvider.badCredentials}"));
    }
}
