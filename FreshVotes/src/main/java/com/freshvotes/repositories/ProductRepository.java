package com.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freshvotes.domain.Product;
import java.util.List;
import com.freshvotes.domain.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// select * from product where user =: user
	List<Product> findByUser(User user);

//	// select * from product where 
//	List<Product> findByName(String name);

}
