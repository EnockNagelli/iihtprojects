package com.forum.ForumProject.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.dao.PostDaoImpl;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.PostService;
import com.forum.forumProject.service.PostServiceImpl;

public class TestPostServiceImpl 
{
	@Mock
	private PostDao postDao;

	@Mock
	private PostDaoImpl postDaoImpl;

	@Mock
	private PostService postService;

	@InjectMocks
	private PostServiceImpl postServiceImpl;

    //----------------------------------------------------------------------------------------------
    static 
	{
		File file = new File("posts_output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("posts_output_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}    

    //----------------------------------------------------------------------------------------------
	@Test
	public void testSavePostsImplTest() throws Exception 
	{
		when(postServiceImpl.savePost(MasterData.getPostDetails())).thenReturn(true);
		
		List<Posts> postFromdb = postDaoImpl.getAllPosts();
		
		File file = new File("posts_output_revised.txt");
		FileUtils.write(file, "\ntestSavePostsImplTest="+(postFromdb != null ? true : false), true);

		//assertEquals(Boolean.TRUE, true);
	}

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
}