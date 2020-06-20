package com.forum.forumProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class Comments implements Serializable 
{
	private static final long serialVersionUID = -1826674065580787782L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentid")
	private int commentId;
	
	@Column(name = "postid")
	private int postId;

	@Size(min = 1, max = 50)
	@Column(name = "tags")
	private String tags;
	
	@Size(min = 1, max = 200)
	@Column(name = "visitorcomment")
	private String visitorComment;
	
	public Comments() {
		super();
	}
	
	public Comments(int commentId, String tags, String visitorComment, int postId) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.tags = tags;
		this.visitorComment = visitorComment;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getVisitorComment() {
		return visitorComment;
	}
	public void setVisitorComment(String visitorComment) {
		this.visitorComment = visitorComment;
	}
}