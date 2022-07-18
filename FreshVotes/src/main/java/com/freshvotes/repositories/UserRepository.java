package com.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.User;

// spring data provides us specific lever of abstraction when it comes
// to work with CRUD (create, read, update, delete data) operations 
// with this code we now have created object that will perform all CRUD operations
// in our database

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	
}
