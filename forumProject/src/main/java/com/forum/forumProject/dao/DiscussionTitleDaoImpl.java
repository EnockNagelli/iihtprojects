package com.forum.forumProject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forum.forumProject.entity.DiscussionTitles;

@Repository
public class DiscussionTitleDaoImpl implements DiscussionTitleDao
{
    @Autowired
    private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	public List<DiscussionTitles> getAllDiscussionTitles() 
	{		
		String hql = "FROM DiscussionTitles";
		return (List<DiscussionTitles>) sessionFactory.getCurrentSession().createQuery(hql).list();
	}
}