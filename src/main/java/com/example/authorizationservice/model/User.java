package com.example.authorizationservice.model;

import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public class User {
    private final String userName;
    private final String password;
    private final List<Authorities> authoritiesList;

    public User(String userName, String password, List<Authorities> authoritiesList) {
        this.userName = userName;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }
}
