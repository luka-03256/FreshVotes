package com.freshvotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class CommentId implements Serializable {

	private static final long serialVersionUID = -3690211290276882371L;

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
		if (this != obj) {
			return false;
		}
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof CommentId)) {
			return false;
		}

		CommentId second = (CommentId) obj;
		if (this.getUser() != second.getUser() || this.getFeature() != second.getFeature()) {
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
		return 0;
	}

}
