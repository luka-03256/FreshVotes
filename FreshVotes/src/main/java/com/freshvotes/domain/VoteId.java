package com.freshvotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

// implementing serializable interface for ability to exchange object with other(entities machines)
@Embeddable
public class VoteId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// just many to one relationship 
	private User user;
	private Feature feature;
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	
	
	
	
}
