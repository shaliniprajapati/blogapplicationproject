package com.example.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
