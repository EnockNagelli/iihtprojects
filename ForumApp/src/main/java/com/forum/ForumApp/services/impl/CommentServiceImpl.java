package com.forum.ForumApp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.forum.ForumApp.dao.CommentsDao;
import com.forum.ForumApp.entity.Comments;
import com.forum.ForumApp.services.CommentService;

public class CommentServiceImpl implements CommentService
{
	@Autowired
	CommentsDao comments;

	public boolean saveComment(Comments comments)
	{
		return true;
	}

}
