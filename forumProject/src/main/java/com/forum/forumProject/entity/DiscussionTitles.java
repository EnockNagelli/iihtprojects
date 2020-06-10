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
@Table(name = "DiscussionTitles")
public class DiscussionTitles implements Serializable
{
	private static final long serialVersionUID = -6323764382950867829L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "titleId")
	private int titleId;
		
	@Size(min = 5, max = 200)
	@Column(name = "description")
	private String discussionTitle;

	public DiscussionTitles() {
		super();
	}

	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getDiscussionTitle() {
		return discussionTitle;
	}
	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}
}