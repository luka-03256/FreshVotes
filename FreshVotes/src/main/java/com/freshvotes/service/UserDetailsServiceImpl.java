package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.User;
import com.freshvotes.repositories.UserRepository;
import com.freshvotes.security.CustomSecurityUser;

// when object in java imports interface naming convention
// says name + Impl
// Impl - stands for import

// error was happening because we haven't managed our UserDetailServiceImpl
// with @Service - annotation
// that's why circle error occured
// spring hadn't been able to recognize this class and it's methods
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	// our service needs to interact with our repositories
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// it should access our database and fetch username
		// compare username && and passwords
		User user = userRepo.findByUsername(username);
		
		// we don't want to allow hackers based on return message to figure
		// out which usernames exist and which don't
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username and password");
		}
		
		return new CustomSecurityUser(user);
	}
	
	


}
