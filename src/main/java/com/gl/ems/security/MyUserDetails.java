package com.gl.ems.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;

public class MyUserDetails implements UserDetails{
    private User user;
        
	public MyUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles= user.getRoles();
		List<SimpleGrantedAuthority> authorities= new ArrayList<>();
		for(Role user:roles)
		{String rName = user.getName();
		
		SimpleGrantedAuthority sga = 
			new SimpleGrantedAuthority(rName);
		
		authorities.add(sga);
			
			
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
   

}
