package com.freshvotes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// implementation of POJO - plain old java object(design pattern)
@Entity
@Table(name = "feature")
public class Feature {
	// class fields static || non-static
	private Long id;
	private String title;
	private String description;
	private String status;
	private Product product;

	// getters accessory methods && setters mutational methods
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment id, newer spring-boot version uses GenerationType.IDENTITY because hibernate create specific table
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
