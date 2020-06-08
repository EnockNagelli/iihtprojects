package com.forum.forumProject.dao;

import java.util.List;

import com.forum.forumProject.entity.Comments;

public interface CommentsDao 
{
	public void saveComment(Comments comments);
	
	public List<Comments> getAllComments();
}
