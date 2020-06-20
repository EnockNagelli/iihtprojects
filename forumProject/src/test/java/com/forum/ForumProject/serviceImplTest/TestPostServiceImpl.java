package com.forum.ForumProject.serviceImplTest;

import static com.forum.ForumProject.UtilTestClass.TestUtils.businessTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.currentTest;
import static com.forum.ForumProject.UtilTestClass.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.PostService;
import com.forum.forumProject.service.PostServiceImpl;

public class TestPostServiceImpl 
{
	@Mock
	private PostDao postDao;

	@Mock
	private PostService postService;

	@InjectMocks
	private PostServiceImpl postServiceImpl;

    //----------------------------------------------------------------------------------------------
	/*
	 * static { File file = new File("posts_output_revised.txt"); if (file.exists())
	 * { try { FileUtils.forceDelete(new File("posts_output_revised.txt")); } catch
	 * (IOException e) { // TODO Auto-generated catch block // e.printStackTrace();
	 * } } }
	 */
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
		
		List<Posts> postFromdb = postDao.getAllPosts();
		
	    yakshaAssert(currentTest(), "\ntestSavePostsImplTest="+(postFromdb != null ? true : false), businessTestFile);

	    //File file = new File("posts_output_revised.txt");
		//FileUtils.write(file, "\ntestSavePostsImplTest="+(postFromdb != null ? true : false), true);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testPostServiceImplTest() throws Exception 
	{
		boolean value = postServiceImpl.savePost(MasterData.getPostDetails());
		
	    yakshaAssert(currentTest(), "\ntestPostServiceImplTest="+(value ? true : false), businessTestFile);

	    //File file = new File("posts_output_revised.txt");
	    //FileUtils.write(file, "\ntestPostServiceImplTest="+(value ? true : false), true);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllPostsImplTest() throws Exception 
	{	
		List<Posts> list = new ArrayList<Posts>();
		list.add(new Posts());
		list.add(new Posts());

		when(postServiceImpl.getAllPosts()).thenReturn((List<Posts>) list);
		
		List<Posts> postFromdb = postDao.getAllPosts();

	    yakshaAssert(currentTest(), "\ntestViewAllPostsImplTest="+(postFromdb==list ? true : false), businessTestFile);

	    //File file = new File("posts_output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllPostsImplTest="+(postFromdb==list ? true : false), true);
	}
	
	
	@Test 
	public void testViewAllPostsImplTest1() throws Exception 
	{ 
		List<Posts> list = new ArrayList<Posts>();
	  
		when(postServiceImpl.getAllPosts()).thenReturn((List<Posts>) list);
	  
		List<Posts> postsFromdb = postDao.getAllPosts();
	  
	    yakshaAssert(currentTest(), "\ntestViewAllPostsImplTest1="+(postsFromdb==list ? true : false), businessTestFile);

	    //File file = new File("posts_output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllPostsImplTest1="+(postsFromdb==list ? true : false), true); 
	}
	  
	@Test 
	public void testViewAllPostsImplTest2() throws Exception 
	{ 
		when(postServiceImpl.getAllPosts()).thenReturn(null);
	  
		List<Posts> postsFromdb = postDao.getAllPosts();
	  
	    yakshaAssert(currentTest(), "\ntestViewAllPostsImplTest2="+(postsFromdb==null ? true : false), businessTestFile);

	    //File file = new File("posts_output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllPostsImplTest2="+(postsFromdb==null ? true : false), true);
	} 
}