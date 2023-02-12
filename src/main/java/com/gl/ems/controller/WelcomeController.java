package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;
import com.gl.ems.service.UserService;

@RestController
public class WelcomeController {
	@Autowired
	private UserService service;
	
	@PostMapping("/createuser")
    public User createUser(@RequestBody  User user) {
	return service.addUser(user);
	
}
	@PostMapping("/createroles")
    public Role createUser(@RequestBody  Role roles) {
	return service.addRoles(roles);
	
}
}
