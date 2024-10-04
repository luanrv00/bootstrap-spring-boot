package com.luarnv00.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luarnv00.quickstart.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}