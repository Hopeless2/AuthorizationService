package com.example.authorizationservice.config;

import com.example.authorizationservice.repository.UserRepository;
import com.example.authorizationservice.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationService service(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public UserRepository repository() {
        return new UserRepository();
    }
}
