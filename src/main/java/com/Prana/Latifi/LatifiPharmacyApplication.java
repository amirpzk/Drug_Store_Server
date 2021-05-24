package com.Prana.Latifi;

import com.Prana.Latifi.entity.*;
import com.Prana.Latifi.repository.RoleRepo;
import com.Prana.Latifi.repository.UserRepo;
import com.Prana.Latifi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LatifiPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatifiPharmacyApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired private RoleRepo roleRepo;
	@Autowired private UserRepo userRepo;
	@Autowired private PasswordEncoder passwordEncoder;

	@PostConstruct
	private void adminCreation() {
		if (roleRepo.findAll().isEmpty()) {
			Role adminRole = roleRepo.save(new Role("ADMIN", ""));
			Role userRole = roleRepo.save(new Role("USER", ""));
		}

		if (userRepo.findAll().isEmpty()) {

			Role adminRole = roleRepo.findById(1L).get();
			List<Role> adminRoleList = new ArrayList<>();
			adminRoleList.add(adminRole);

			User user = new User();
			user.setUsername("Latifi_Admin");
			user.setPassword(passwordEncoder.encode("Latifi_Admin_Password"));
			user.setActive(true);
			user.setVerified(true);
			user.setType(UserUsernameType.PHONE_NUMBER);
			user.setRoles(adminRoleList);

			userRepo.save(user);
		}
	}

}
