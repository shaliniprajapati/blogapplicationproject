package com.example.blogapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.entities.User;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.payloads.UserDdo;
import com.example.blogapp.repositories.UserRepo;
import com.example.blogapp.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userrepo;
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public UserDdo createUser(UserDdo userddo) {
		// TODO Auto-generated method stub
		User user=this.userddotouser(userddo);
		User savedUser=this.userrepo.save(user);
		return this.usertouserddo(savedUser);
		}

	@Override
	public UserDdo updateUser(UserDdo userddo, Integer userId) {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId).orElseThrow((()->new ResourceNotFoundException("user","id",userId)));
		
		user.setName(userddo.getName());
		user.setEmail(userddo.getEmail());
		user.setAbout(userddo.getEmail());
		user.setPassword(userddo.getPassword());
		User saveduser=userrepo.save(user);
		UserDdo userddo1=this.usertouserddo(saveduser);
		return userddo1;
	}

	@Override
	public UserDdo getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "ID",userId));
		UserDdo userddo1=this.usertouserddo(user);
		return userddo1;
	}

	@Override
	public List<UserDdo> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> userlist=userrepo.findAll();
		List<UserDdo> users=userlist.stream().map(user->this.usertouserddo(user)).collect(Collectors.toList());
		return users;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId).orElseThrow((()->new ResourceNotFoundException("user","id",userId)));
		userrepo.delete(user);
	}
	private User userddotouser(UserDdo userddo)
	{
		User user=modelmapper.map(userddo, User.class);
		return user;
	}
	private UserDdo usertouserddo(User user) {
		UserDdo userddo=modelmapper.map(user, UserDdo.class);
		return userddo;
	}

}
