package ru.converter.oauthdbtools.domains.UserOauth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    USER_CONVERTER(Set.of(Permission.VALUTE_CONVERT)),
    ADMIN(Set.of(Permission.VALUTE_CONVERT, Permission.VALUTE_CHANGE, Permission.VALUTE_VIEW)),
    USER_VIEWER(Set.of(Permission.VALUTE_VIEW));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }



}
