package com.forum.forumProject.service;

import java.util.List;

import com.forum.forumProject.entity.Comments;

public interface CommentService 
{
	public Boolean saveComment(Comments comments);
	
	public List<Comments> getAllComments();
}
