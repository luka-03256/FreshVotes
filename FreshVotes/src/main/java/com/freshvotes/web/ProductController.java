package com.freshvotes.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repositories.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping(value = "/products")
	public String getProducts(@AuthenticationPrincipal User user,ModelMap model) {
		List<Product> products = productRepo.findByUser(user);
		model.put("products", products);
		
		return "products";
	}

	@GetMapping(value = "/product")
	public String getProduct(ModelMap model) {
		return "product";
	}

	// {productId} -> open up the page with given productId and display information
	// fetched from database
	@GetMapping(value = "/product/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response)
			throws IOException {
		Optional<Product> productOpt = productRepo.findById(productId);

		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			model.put("product", product);

		} else {
			Product product = productOpt.get();
			model.put("product", product);

			// if we don't find productOpt we explicitly set status
			// 404 not found
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " wasn't found");
			return "product";
		}

		return "product";
	}

	@PostMapping(value = "/product/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {
		System.out.println(product);
		product = productRepo.save(product);
		return "redirect:/product/" + product.getId();
	}

	@PostMapping(value = "/product")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();

		product.setPublished(false);
		product.setUser(user);
		product = productRepo.save(product);

		// redirect us to page with current product id
		// fetched from our database
		return "redirect:/product/" + product.getId();
	}

}
