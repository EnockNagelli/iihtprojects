package com.forum.ForumApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.ForumApp.dao.CommentsDao;
import com.forum.ForumApp.entity.Comments;

@Service
public class CommentService {

	@Autowired
	CommentsDao comments;
	
	public boolean saveComment(Comments comments)
	{
		return true;
	}
}