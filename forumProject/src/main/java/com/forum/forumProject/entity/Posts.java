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
@Table(name = "postData")
public class Posts implements Serializable 
{
	private static final long serialVersionUID = -1826674065580787782L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postid")
	private int postId;
	
	@Size(min = 5, max = 30)
	@Column(name = "title")
	private String title;
	
	@Size(min = 5, max = 30)
	@Column(name = "tags")
	private String tags;
	
	@Size(min = 5, max = 200)
	@Column(name = "postDescription")
	private String postDescription;
	
	public Posts() {
		super();
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}	
}
