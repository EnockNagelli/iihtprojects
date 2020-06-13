package com.forum.ForumProject.serviceImplTest;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.dao.PostDaoImpl;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.PostService;
import com.forum.forumProject.service.PostServiceImpl;

public class TestPostServiceImpl 
{
	@Mock
	private PostService postService;

	@Mock
	private PostDaoImpl postDaoImpl;

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

	// -------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() 
	{
		MockitoAnnotations.initMocks(this);
	}

    //----------------------------------------------------------------------------------------------
	@Test
	public void testSavePostsImplTest() throws Exception 
	{
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(true);
		
		List<Posts> postFromdb = postDaoImpl.getAllPosts();
		
		File file = new File("posts_output_revised.txt");
		FileUtils.write(file, "\ntestSavePostsImplTest="+(postFromdb != null ? true : false), true);

		//assertEquals(Boolean.TRUE, true);
	}

	@Test
	public void testViewAllPostsImplTest() throws Exception 
	{	
		List<Posts> list = new ArrayList<Posts>();
		list.add(new Posts());
		list.add(new Posts());

		when(postService.getAllPosts()).thenReturn((List<Posts>) list);
		
		List<Posts> postFromdb = postDaoImpl.getAllPosts();

		File file = new File("posts_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllPostsImplTest="+(postFromdb==list ? true : false), true);

		//assertEquals(2, list.size());
	}
	
	
	@Test 
	public void testViewAllPostsImplTest1() throws Exception 
	{ 
		List<Posts> list = new ArrayList<Posts>();
	  
		when(postService.getAllPosts()).thenReturn((List<Posts>) list);
	  
		List<Posts> postsFromdb = postDaoImpl.getAllPosts();
	  
		File file = new File("posts_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllCommentsImplTest1="+(postsFromdb==list ? true : false), true); 

		//assertEquals(Collections.EMPTY_LIST, list); 
	}
	  
	@Test 
	public void testViewAllPostsImplTest2() throws Exception 
	{ 
		when(postService.getAllPosts()).thenReturn(null);
	  
		List<Posts> postsFromdb = postDaoImpl.getAllPosts();
	  
		File file = new File("comments_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllCommentsImplTest2="+(postsFromdb==null ? true : false), true);

		//assertEquals(null, list); 
	} 
}