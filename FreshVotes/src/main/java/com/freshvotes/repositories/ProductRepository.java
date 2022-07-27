package com.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.freshvotes.domain.Product;
import java.util.List;
import java.util.Optional;

import com.freshvotes.domain.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// select * from product where user =: user
	List<Product> findByUser(User user);

	// create new query
	// join fetch grab the data p.user
	@Query("select p from Product p" + " join fetch p.user" + " where p.id = :id")
	Optional<Product> findByIdWithUser(Long id);

//	// select * from product where 
//	List<Product> findByName(String name);

}
