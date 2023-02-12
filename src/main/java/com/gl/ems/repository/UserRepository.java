package com.gl.ems.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gl.ems.entity.Role;
import com.gl.ems.entity.User;
     
      public interface UserRepository extends JpaRepository<User, Long> {
       @Query("SELECT u FROM User u WHERE u.username = ?1")	  
       public User getUserByUsername(String username);

	    public Role save(Role roles);

		public void save(List<Role> role);
}
