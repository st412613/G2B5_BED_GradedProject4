package com.gl.ems.service;

import java.util.List;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;

public interface UserService {
	
    List<User> listUserInfo();
	User addUser(User user);
	Role addRoles(Role roles);

}
