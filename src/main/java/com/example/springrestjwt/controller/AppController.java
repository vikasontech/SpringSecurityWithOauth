package com.example.springrestjwt.controller;

import com.example.springrestjwt.controller.entity.User;
import com.example.springrestjwt.controller.repo.UserRepository;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    private final UserRepository userRepository;

    public AppController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping( value = "/hello/user", method = RequestMethod.GET)
    @PostAuthorize("hasAuthority('USER')")
    public String helloUser() {
        return "Hello User!!!";
    }

    @RequestMapping( value = "/hello/admin", method = RequestMethod.GET)
    @PostAuthorize("hasAuthority('ADMIN')")
    public String helloAdmin() {
        return "Hello Admin!!!";
    }

    @GetMapping("/listAll")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

}