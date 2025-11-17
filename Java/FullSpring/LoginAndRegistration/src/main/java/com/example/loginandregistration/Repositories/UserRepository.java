package com.example.loginandregistration.Repositories;

import com.example.loginandregistration.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);
}
