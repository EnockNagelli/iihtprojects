package com.forum.forumProject.service;

import java.util.List;

import com.forum.forumProject.entity.Posts;

public interface PostService 
{
	public void savePost(Posts posts);
	
	public List<Posts> getAllPosts();
}
