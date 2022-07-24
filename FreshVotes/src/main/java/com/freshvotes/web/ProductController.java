package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repositories.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping(value = "/products")
	public String getProducts(ModelMap model) {
		return "products";
	}

	// {productId} -> open up the page with given productId and display information
	// fetched from database
	@GetMapping(value="/products/{productId}")
	public String getProduct(@PathVariable Long productId) {
		return "products";
	}

	@PostMapping(value = "/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();

		product.setPublished(false);
		product.setUser(user);
		product = productRepo.save(product);

		// redirect us to page with current product id
		// fetched from our database
		return "redirect:/products/" + product.getId();
	}

}
