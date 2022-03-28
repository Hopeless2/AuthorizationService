package com.example.authorizationservice.repository;

import com.example.authorizationservice.exception.InvalidCredentials;
import com.example.authorizationservice.model.Authorities;
import com.example.authorizationservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = List.of(new User("1", "1", List.of(Authorities.READ)),
            new User("2", "2", new ArrayList<>()));

    public List<Authorities> getUserAuthorities(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user.getAuthoritiesList();
            }
        }
        throw new InvalidCredentials("User name or password is incorrect");
    }
}