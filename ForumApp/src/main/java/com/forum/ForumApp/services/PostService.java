package com.forum.ForumApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forum.ForumApp.entity.Posts;

@Service
public interface PostService 
{
	public boolean savePost(Posts posts);
	
	public List<Posts> getAllPosts();
}
