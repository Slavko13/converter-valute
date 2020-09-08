package ru.converter.oauthserver.principal;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.converter.oauthdb.domains.user.AuthoritiesEnum;
import ru.converter.oauthdb.domains.user.Status;
import ru.converter.oauthdb.domains.user.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class UserPrincipal implements UserDetails {

    private final String userName;
    private final String password;
    private final Set<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public UserPrincipal(User user) {
        this.userName = user.getLogin();
        this.password = user.getPassword();
        this.authorities = user.getRole().getAuthorities()
                .stream().map(this::getGrantedAuthority).collect(Collectors.toSet());
        this.isActive = user.getStatus().equals(Status.ACTIVE);
    }

    private SimpleGrantedAuthority getGrantedAuthority(AuthoritiesEnum authority) {
        return new SimpleGrantedAuthority(authority.name());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
