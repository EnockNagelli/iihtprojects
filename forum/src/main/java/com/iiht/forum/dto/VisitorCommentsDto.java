package com.iiht.forum.dto;

public class VisitorCommentsDto {

	private long commentId;
	private long postId;
	private String tags;
	private String visitorComment;

	public VisitorCommentsDto() {
		super();
	}

	public VisitorCommentsDto(long commentId, long postId, String tags, String visitorComment) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.tags = tags;
		this.visitorComment = visitorComment;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
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