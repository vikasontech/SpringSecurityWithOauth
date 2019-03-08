package com.example.springrestjwt.repository;


import com.example.springrestjwt.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findOneByUsername(String username);
}
