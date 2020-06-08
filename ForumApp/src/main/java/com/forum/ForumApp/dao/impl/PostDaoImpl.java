package com.forum.ForumApp.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.forum.ForumApp.dao.PostDao;
import com.forum.ForumApp.entity.Posts;
 
public class PostDaoImpl implements PostDao 
{
    @Autowired
    private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	public List<Posts> getPosts() {		
		String hql = "FROM Posts";				// as g ORDER BY g.postId";
		return (List<Posts>) sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public void savePost(Posts posts) {
		sessionFactory.getCurrentSession().persist(posts);
	}    
}