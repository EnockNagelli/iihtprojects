package com.forum.ForumApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.forum.ForumApp.dao.PostDao;
import com.forum.ForumApp.entity.Posts;
import com.forum.ForumApp.services.PostService;

public class PostServiceImpl implements PostService
{
	@Autowired
	PostDao postsDao;
	
	public boolean savePost(Posts posts)
	{
		postsDao.savePost(posts);
		return true;
	}

	public List<Posts> getAllPosts()
	{
		List<Posts> list = new ArrayList<Posts>();
		
		return list;
	}	

}
