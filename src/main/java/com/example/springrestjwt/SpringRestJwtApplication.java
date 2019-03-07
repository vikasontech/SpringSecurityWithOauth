package com.example.springrestjwt;

import com.example.springrestjwt.controller.entity.Role;
import com.example.springrestjwt.controller.entity.User;
import com.example.springrestjwt.controller.repo.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;


@SpringBootApplication
public class SpringRestJwtApplication {
    private final UserRepository userRepository;

    public SpringRestJwtApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestJwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {

        Role userRole = Role.builder()
                .roleName("USER")
                .description("user role").build();

        // create user with role "USER"
        User user = User.builder().firstName("user")
                .lastName("user")
                .username("user")
                .password("$2a$04$5orSPmrUIRCYyVYwkLjE1OyEGTlkRkGd/5vWYlPvtvK8rzbJIoUIG")
                .roles(new HashSet<>(Arrays.asList(userRole)))
                .build();

        userRole = Role.builder()
                .roleName("USER")
                .description("user role").build();

        Role adminRole = Role.builder()
                .roleName("ADMIN")
                .description("admin role.").build();

        // create user with role "USER" and "ADMIN"
        User adminUser = User.builder()
                .firstName("admin")
                .lastName("admin")
                .username("admin")
                .password("password")
                .roles(new HashSet<>(Arrays.asList(userRole, adminRole)))
                .build();

        return args -> {
            userRepository.save(user);
            userRepository.save(adminUser);
        };
    }
}
