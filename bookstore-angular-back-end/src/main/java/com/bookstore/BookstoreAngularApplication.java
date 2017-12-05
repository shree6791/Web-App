package com.bookstore;

import java.util.Set;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;

import com.bookstore.service.UserService;
import com.bookstore.config.SecurityUtility;

@SpringBootApplication
public class BookstoreAngularApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreAngularApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		// Initilaise User and Role
		
		User user1 = new User();
		User user2 = new User();
		
		Role role1 = new Role();
		Role role2 = new Role();
		
		Set<UserRole> userRoles = new HashSet<>();
		
		// Store User 1 and corresponding Role in db
		
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setEmail("JAdams@gmail.com");
		
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);		
		userRoles.clear();
		
		// Store User 2 and corresponding Role in db
		
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setEmail("Admin@gmail.com");
		
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
	}
	
}
