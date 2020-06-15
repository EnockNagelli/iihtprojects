package com.forum.forumProject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forum.forumProject.entity.Comments;

@Repository
public class CommentsDaoImpl implements CommentsDao
{
    @Autowired
    private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> getAllComments() {		
		String hql = "FROM Comments";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void saveComment(Comments comments) {
		sessionFactory.getCurrentSession().persist(comments);
	}
}
