package com.forum.ForumApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name ="comments")
public class Comments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId")
	private String commentId;

	@Size(min = 5, max = 30)
	@Column(name = "postId")
	private String postId;
	
	@Size(min = 5, max = 30)
	@Column(name = "tags")
	private String tags;
	
	@Size(min = 5, max = 100)
	@Column(name = "commentNote")
	private String commentDescription;

	public Comments() {
		super();
	}
	
	public Comments(String commentId, String postId, String tags, String commentDescription) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.tags = tags;
		this.commentDescription = commentDescription;
	}

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}	
}