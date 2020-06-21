package com.forum.ForumProject.FunctionalTestCases;

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
//import org.springframework.http.HttpStatus;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.CommentsDao;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentServiceImpl;
import com.forum.forumProject.service.PostServiceImpl;

public class TestFunctional 
{	
	@Mock
	private PostDao postDao;
	@Mock
	private CommentsDao commentsDao;

	@Mock
	private Posts posts;

	@InjectMocks
	private PostServiceImpl postServiceImpl;
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;
	
	//--------------------------------------------------------------------------------------------------------------------------------
	/*
	 * static { File file = new File("output_revised.txt"); if (file.exists()) { try
	 * { FileUtils.forceDelete(new File("output_revised.txt")); } catch (IOException
	 * e) { // TODO Auto-generated catch block // e.printStackTrace(); } } }
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSavePosts() throws Exception 
	{
		boolean value = postServiceImpl.savePost(MasterData.getPostDetails());
		
	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);
		
		//File file = new File("output_revised.txt");
	    //FileUtils.write(file, "\ntestSavePosts="+(value ? true : false), true); 
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveComments() throws Exception 
	{
		boolean value = commentServiceImpl.saveComment(MasterData.getCommentDetails());

	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);

		//File file = new File("output_revised.txt");
	    //FileUtils.write(file, "\ntestSaveComments="+(value ? true : false), true); 
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllPosts() throws Exception 
	{
		List<Posts> list = new ArrayList<Posts>();
		list.add(new Posts());
		list.add(new Posts());
	    
	    when(postDao.getAllPosts()).thenReturn((List<Posts>) list);
		List<Posts> postFromdb = postServiceImpl.getAllPosts();

	    yakshaAssert(currentTest(), postFromdb==list ? true : false, businessTestFile);

	    //File file = new File("output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllPosts="+(postFromdb==list ? true : false), true); 
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllComments() throws Exception 
	{
		List<Comments> list = new ArrayList<Comments>();
		list.add(new Comments());
		list.add(new Comments());
	    
	    when(commentsDao.getAllComments()).thenReturn((List<Comments>) list);
		List<Comments> commentFromdb = commentServiceImpl.getAllComments();

	    yakshaAssert(currentTest(), commentFromdb==list ? true : false, businessTestFile);

	    //File file = new File("output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllComments="+(commentFromdb==list ? true : false), true); 
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllDiscussions() throws Exception 
	{
		List<Posts> list = new ArrayList<Posts>();
		list.add(new Posts());
		list.add(new Posts());
	    
	    when(postDao.getAllPosts()).thenReturn((List<Posts>) list);
		List<Posts> discussionFromdb = postServiceImpl.getAllPosts();

	    yakshaAssert(currentTest(), discussionFromdb==list ? true : false, businessTestFile);

	    //File file = new File("output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllDiscussions="+(discussionFromdb==list ? true : false), true); 
	}	
}