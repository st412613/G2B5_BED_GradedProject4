package com.gl.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;
import com.gl.ems.service.UserService;

@RestController //// This is controller class for User And Role
public class UserAndRoleController {
	@Autowired
	private UserService service;
     //This API able to add Users in the db 
	//which can be used for authentication purposes.
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return service.addUser(user);

	}
    //This API able to add roles
	//in the database dynamically in the db
	@PostMapping("/createroles")
	public Role createUser(@RequestBody Role roles) {
		return service.addRoles(roles);

	}
}
