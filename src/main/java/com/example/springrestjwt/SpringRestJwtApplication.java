package com.example.springrestjwt;

import com.example.springrestjwt.controller.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringRestJwtApplication {
    private final UserRepository userRepository;

    public SpringRestJwtApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestJwtApplication.class, args);
    }
}
