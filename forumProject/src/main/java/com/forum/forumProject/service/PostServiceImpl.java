package com.forum.forumProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.entity.Posts;

@Service
@Transactional
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostDao postDao;
	
	@Override
	public Boolean savePost(Posts posts) {
		postDao.savePost(posts);
		return true;
	}

	@Override
	public List<Posts> getAllPosts() {
		return postDao.getAllPosts();
	}

	//@Override
	//public List<String> getAllPostTitles() {
	//	return postDao.getPostTitles();
	//}	
}
