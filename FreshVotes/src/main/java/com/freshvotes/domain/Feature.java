package com.freshvotes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// implementation of POJO - plain old java object(design pattern)
@Entity
@Table(name="feature")
public class Feature {
	// class fields static || non-static
	private Long id;
	private String title;
	private String description;
	private boolean status;
	
	
	// getters accessory methods && setters mutational methods
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment id
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	

}
