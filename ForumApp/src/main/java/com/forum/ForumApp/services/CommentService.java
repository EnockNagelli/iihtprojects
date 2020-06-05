package com.forum.ForumApp.services;

import org.springframework.stereotype.Service;

import com.forum.ForumApp.entity.Comments;

@Service
public interface CommentService 
{	
	public boolean saveComment(Comments comments);
}