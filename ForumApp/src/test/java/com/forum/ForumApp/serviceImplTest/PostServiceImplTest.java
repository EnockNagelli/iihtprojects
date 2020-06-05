package com.forum.ForumApp.serviceImplTest;

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

import com.forum.ForumApp.UtilTestClass.MasterData;
import com.forum.ForumApp.dao.PostDao;
import com.forum.ForumApp.dao.impl.PostDaoImpl;
import com.forum.ForumApp.entity.Posts;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {
	
	@Mock
	private PostDao postDAO;

	@InjectMocks
	private com.forum.ForumApp.services.impl.PostServiceImpl PostServiceImpl;
	
	@Test
	public void testViewAllOrdersImplTest() throws Exception 
	{
		List<Posts> posts = new ArrayList<>();
		
		posts.add(new Posts());
			
		when(new PostDaoImpl().getPosts()).thenReturn((List<Posts>) posts);
		
		List<Posts> list = PostServiceImpl.getAllPosts();
		
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewAllOrdersImplTest1() throws Exception 
	{
		List<Posts> posts = new ArrayList<>();
				
		when(new PostDaoImpl().getPosts()).thenReturn((List<Posts>) posts);
		
		List<Posts> list = PostServiceImpl.getAllPosts();
	    
		assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllOrdersImplTest2() throws Exception 
	{
		when(new PostDaoImpl().getPosts()).thenReturn(null);
	
		List<Posts> list = PostServiceImpl.getAllPosts();
	    
		assertEquals(null, list);
	}
	
	@Test
	public void testSaveOrdersImplTest() throws Exception 
	{
		Boolean value = PostServiceImpl.savePost(MasterData.getPostDetails());
	
		assertEquals(Boolean.TRUE, value);
	}
}