package com.forum.forumProject.dao;

import java.util.List;

import com.forum.forumProject.entity.Posts;

public interface PostDao 
{
	public void savePost(Posts posts);
	
	public List<Posts> getAllPosts();	
}