package com.freshvotes.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Comment {
	// class fields static || non-static
	private String text;
	private CommentId pk; // pk - stands for public key
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@EmbeddedId
	public CommentId getPk() {
		return pk;
	}
	
	public void setPk(CommentId pk) {
		this.pk = pk;
	}
	
	
	
	
}
