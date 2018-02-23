package com.example.springrestjwt.controller.repo;

import com.example.springrestjwt.controller.entity.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findOneByUsername(String username);
}
