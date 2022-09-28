package com.example.blogapp.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.UserDdo;
import com.example.blogapp.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {	
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity<UserDdo> createUser(@Valid @RequestBody UserDdo userDdo){
	UserDdo createUserDdo=userService.createUser(userDdo);
	return new ResponseEntity<>(createUserDdo, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDdo> updateUser(@Valid @RequestBody UserDdo userDdo,@PathVariable("id") Integer userId){
	UserDdo updateuserddo=userService.updateUser(userDdo, userId);
	return ResponseEntity.ok(updateuserddo);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDdo> getUserById(@PathVariable("id") Integer userId) {
	return ResponseEntity.ok(userService.getUserById(userId));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse> (new ApiResponse("user deleted",true), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<UserDdo>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
