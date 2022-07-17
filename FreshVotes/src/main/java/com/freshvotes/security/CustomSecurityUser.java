package com.freshvotes.security;

import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import com.freshvotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3321129803633470403L;

	// default constructor
	public CustomSecurityUser() {
		// ...
	}

	// parameterized constructor
	public CustomSecurityUser(User user) {
		this.setAuthorities(getAuthorities());
		this.setId(getId());
		this.setName(getUsername());
		this.setPassword(getPassword());
		this.setUsername(getUsername());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	// if one of down bellow override methods returns false
	// we don't want user to be authorized
	// what should be done is this values shall be stored in database
	// and we should return them when checking user authentication
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
