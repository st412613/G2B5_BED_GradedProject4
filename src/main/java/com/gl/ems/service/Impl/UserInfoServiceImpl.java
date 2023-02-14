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
		List<Role> roles = user.getRoles();//separate role from user
		Role s = new Role();
		for (Role role : roles) {
			s.setId(role.getId());
			s.setName(role.getName());

		}
		repo.save(s);

		User newuser = new User();
		newuser.setUsername(user.getUsername());
		newuser.setPassword(passwordEncoder.encode(user.getPassword()));

		repo.save(newuser);
		newuser.setRoles(roles);

		return newuser;

	}

	@Override
	public Role addRoles(Role roles) {

		return repo.save(roles);
	}

}
