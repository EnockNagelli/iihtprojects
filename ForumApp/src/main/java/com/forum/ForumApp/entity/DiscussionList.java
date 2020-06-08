package com.forum.ForumApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="discussionList")
public class DiscussionList
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "discussionId")
	private String discussionId;
	
	@Size(min = 5, max = 50)
	@Column(name = "discussionTitle")
	private String discussionTitle;
	
	public DiscussionList() {
		super();
	}
	
	public DiscussionList(String discussionId, String discussionTitle) {
		super();
		this.discussionId = discussionId;
		this.discussionTitle = discussionTitle;
	}

	public String getDiscussionId() {
		return discussionId;
	}
	public void setDiscussionId(String discussionId) {
		this.discussionId = discussionId;
	}

	public String getDiscussionTitle() {
		return discussionTitle;
	}
	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}	
}