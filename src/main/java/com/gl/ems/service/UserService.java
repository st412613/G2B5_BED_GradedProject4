package com.gl.ems.service;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;

public interface UserService {
	
    
	User addUser(User user);
	Role addRoles(Role roles);

}
