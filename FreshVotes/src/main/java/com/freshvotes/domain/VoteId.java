package com.freshvotes.domain;

import java.io.Serializable;

import javax.naming.Name;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

// implementing serializable interface for ability to exchange object with other(entities machines)
@Embeddable
public class VoteId implements Serializable{
	
	private static final long serialVersionUID = 6202269445639364170L;
	
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
	
	
	@Override
	public boolean equals(Object obj) {
		if(this != obj) {
			return false;
		}
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof VoteId)) {
			return false;
		}
		
		VoteId second = (VoteId) obj;
		if(this.getUser() != second.getUser() || this.getFeature() != second.getFeature()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) serialVersionUID;
		hash = 31 * hash + (user.getName() == null ? 0 : user.hashCode());
		hash = 31 * hash + (user.getPassword() == null ? 0 : user.hashCode());
		return hash;
	}
	
	
	
}
