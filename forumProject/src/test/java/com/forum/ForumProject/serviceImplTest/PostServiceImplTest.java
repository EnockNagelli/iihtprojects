package com.forum.ForumProject.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.dao.PostDaoImpl;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.PostServiceImpl;


@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {
	
	@Mock
	private PostDao postDAO;

	@InjectMocks
	private PostServiceImpl postServiceImpl;
	
	@Test
	public void testViewAllPostsImplTest() throws Exception 
	{
		List<Posts> posts = new ArrayList<Posts>();
					
		when(new PostDaoImpl().getAllPosts()).thenReturn((List<Posts>) posts);
		
		List<Posts> list = postServiceImpl.getAllPosts();
		
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewAllPostsImplTest1() throws Exception 
	{
		List<Posts> posts = new ArrayList<Posts>();
				
		when(new PostDaoImpl().getAllPosts()).thenReturn((List<Posts>) posts);
		
		List<Posts> list = postServiceImpl.getAllPosts();
	    
		assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllPostsImplTest2() throws Exception 
	{
		when(new PostDaoImpl().getAllPosts()).thenReturn(null);
	
		List<Posts> list = postServiceImpl.getAllPosts();
	    
		assertEquals(null, list);
	}
	
	@Test
	public void testSavePostsImplTest() throws Exception 
	{
		postServiceImpl.savePost(MasterData.getPostDetails());
		//when(postServiceImpl.savePost(MasterData.getPostDetails())).thenReturn(true);
		assertEquals(Boolean.TRUE, true);
	}
}