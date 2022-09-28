package com.example.blogapp.service;

import java.util.List;

import com.example.blogapp.payloads.UserDdo;

public interface UserService {
UserDdo createUser(UserDdo user);
UserDdo updateUser(UserDdo user, Integer userId);
UserDdo getUserById(Integer userId);
List<UserDdo> getAllUsers();
void deleteUser(Integer userId);
}
