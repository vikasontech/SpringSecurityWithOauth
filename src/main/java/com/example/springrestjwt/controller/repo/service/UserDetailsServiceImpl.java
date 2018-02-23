package com.example.springrestjwt.controller.repo.service;

import com.example.springrestjwt.controller.entity.User;
import com.example.springrestjwt.controller.repo.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        List<SimpleGrantedAuthority> collect = user.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles
                .getRoleName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), collect);

    }
}

