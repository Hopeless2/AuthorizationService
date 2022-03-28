package com.example.authorizationservice.controller;

import com.example.authorizationservice.exception.InvalidCredentials;
import com.example.authorizationservice.exception.UnauthorizedUser;
import com.example.authorizationservice.model.Authorities;
import com.example.authorizationservice.model.User;
import com.example.authorizationservice.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    String handleInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    String handleUnauthorizedUser(UnauthorizedUser e) {
        e.printStackTrace();
        return e.getMessage();
    }

}