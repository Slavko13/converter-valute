package ru.converter.oauthdbtools.domains.UserOauth;

public enum Permission {


    VALUTE_CONVERT("valute:convert"),
    VALUTE_CHANGE("valute:change"),
    VALUTE_VIEW("valute:view");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
