package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.User;
import com.pack.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createNewUser(@RequestBody User user)
	{
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/get_all")
	public ResponseEntity<List<User>> getAllUser() {
		
		return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
	}
}
