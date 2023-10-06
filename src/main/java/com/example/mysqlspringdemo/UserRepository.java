package com.example.mysqlspringdemo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
