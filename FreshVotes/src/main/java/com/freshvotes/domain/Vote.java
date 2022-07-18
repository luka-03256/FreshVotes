package com.freshvotes.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Vote {
	// class fields static || non-static

	// pk is a composite key that's reason why we use @EmbeddedId annotation
	// it contains both IDs here as foreign key the user Id as well as a feature ID
	// so those two
	// combined are composite keys

	private VoteId pk; // pk - stands for primary key
	private Boolean upvote;

	@EmbeddedId
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
