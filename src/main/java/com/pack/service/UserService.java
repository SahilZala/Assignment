package com.pack.service;

import java.util.List;

import com.pack.model.User;

public interface UserService{
	public User createUser(User user);
	public List<User> getAllUser(); 
	public User getUserById(String id);
}
