package com.freshvotes.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;



@Embeddable
@Entity
public class Vote {
	// class fields static || non-static
	
	@EmbeddedId
	private VoteId pk; // pk - stands for primary key
	private Boolean upvote;
	
	
	public VoteId getPk() {
		return pk;
	}
	public void setPk(VoteId pk) {
		this.pk = pk;
	}
	public Boolean getUpvote() {
		return upvote;
	}
	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}
	
	
	
	
	
}
