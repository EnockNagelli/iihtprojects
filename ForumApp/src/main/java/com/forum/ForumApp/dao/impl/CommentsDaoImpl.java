package com.forum.ForumApp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.forum.ForumApp.dao.CommentsDao;
import com.forum.ForumApp.entity.Comments;

public class CommentsDaoImpl implements CommentsDao
{
    @Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveComment(Comments comments) {
		hibernateTemplate.save(comments);
	}	
}