package com.gl.ems.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;
import com.gl.ems.repository.UserRepository;
import com.gl.ems.service.UserService;
@Service
public class UserInfoServiceImpl implements UserService {
	@Autowired
    private UserRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
		
	}
	@Override
	public List<User> listUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Role addRoles(Role roles) {
		
		return repo.save(roles);
	}

	

}
