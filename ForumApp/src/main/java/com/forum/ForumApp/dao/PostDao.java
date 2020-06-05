package com.forum.ForumApp.dao;

import java.util.List;

import com.forum.ForumApp.entity.Posts;

public interface PostDao 
{
	public void savePost(Posts posts);
	public List<Posts> getPosts();
}