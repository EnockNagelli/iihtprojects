package com.forum.forumProject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.forum.forumProject.entity.Posts;
 
@Repository
public class PostDaoImpl implements PostDao 
{
    @Autowired
    private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> getAllPosts() {		
		String hql = "FROM Posts";				// as g ORDER BY g.postId";		  
		 
		//List<Posts> list =  (List<Posts>) sessionFactory.getCurrentSession().createSQLQuery("Select * from postdata").list();
		//for(Posts post:list) 
		//{ 
		//	System.out.println("Child---->"+post); 
		//}
		
		return (List<Posts>) sessionFactory.getCurrentSession().createQuery(hql).list();
		//return (List<Posts>) sessionFactory.getCurrentSession().createSQLQuery("Select * from postdata").list();
	}

	@Override
	public void savePost(Posts posts) {
		sessionFactory.getCurrentSession().persist(posts);
	}    
}