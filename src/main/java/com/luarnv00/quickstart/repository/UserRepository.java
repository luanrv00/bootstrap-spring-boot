package com.luarnv00.quickstart.repository;

import org.springframework.data.repository.CrudRepository;

import com.luarnv00.quickstart.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}