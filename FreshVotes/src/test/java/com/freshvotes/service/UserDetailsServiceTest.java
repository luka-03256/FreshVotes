package com.freshvotes.service;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	@Test
	void generate_encrypted_password() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "password123";
		String encodedPassword = encoder.encode(rawPassword);

		if (matches(rawPassword, encodedPassword)) {
			// if matches == true
			System.out.println(rawPassword);
			System.out.println("true");
			System.out.println(encodedPassword);
			return;
		}
		
		System.out.println(encodedPassword);
	}

	private static boolean matches(String rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return rawPassword.toString().equals(encodedPassword); // if matches return true
		// else return false;
	}

}
