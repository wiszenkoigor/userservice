package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(com.example.userservice.Service.UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Igor Wiszenko", "iwisz", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "John Travolta", "jtrav", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Leonardo", "Dicaprop", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Paweł Ogień", "pognie", "password", new ArrayList<>()));

			userService.addRoleToUser("iwisz", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("iwisz", "ROLE_ADMIN");
			userService.addRoleToUser("iwisz", "ROLE_USER");
			userService.addRoleToUser("iwisz", "ROLE_MANAGER");
			userService.addRoleToUser("jtrav", "ROLE_USER");
			userService.addRoleToUser("Dicaprop", "ROLE_MANAGER");
			userService.addRoleToUser("pognie", "ROLE_USER");
			userService.addRoleToUser("pognie", "ROLE_MANAGER");


		};
	}

}
