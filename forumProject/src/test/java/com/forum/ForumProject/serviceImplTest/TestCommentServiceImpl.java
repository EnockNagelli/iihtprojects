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
import com.forum.forumProject.dao.CommentsDao;
import com.forum.forumProject.dao.CommentsDaoImpl;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.CommentServiceImpl;

public class TestCommentServiceImpl 
{	
	@Mock
	private CommentsDao commentsDao;

	@Mock
	private CommentsDaoImpl commentsDaoImpl;

	@Mock
	private CommentService commentService;
	
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;

	//--------------------------------------------------------------------------------------------------------------------------------
	static 
	{
		File file = new File("comments_output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("comments_output_revised.txt"));
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

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testCommentServiceImplTest() throws Exception 
	{
		//commentServiceImpl.saveComment(MasterData.getCommentDetails());
		//assertEquals(Boolean.TRUE, true);

		boolean value = commentServiceImpl.saveComment(MasterData.getCommentDetails());
		
		File file = new File("comments_output_revised.txt");
	    FileUtils.write(file, "\ntestCommentServiceImplTest="+(value ? true : false), true);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllCommentsImplTest() throws Exception 
	{
		List<Comments> list = new ArrayList<Comments>();
		list.add(MasterData.getCommentDetails());
		list.add(MasterData.getCommentDetails());
		
		//when(new CommentServiceImpl().getAllComments()).thenReturn((List<Comments>) list);
		when(commentServiceImpl.getAllComments()).thenReturn((List<Comments>) list);
		
		//List<Comments> commentFromdb = commentServiceImpl.getAllComments();
		List<Comments> commentFromdb = commentsDao.getAllComments();
	
		//System.out.println(commentFromdb);

		File file = new File("comments_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllCommentsImplTest="+(commentFromdb==list ? true : false), true); 
		
		//assertEquals(2, list.size()); 
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllCommentsImplTest1() throws Exception
	{
		List<Comments> list = new ArrayList<Comments>();
		  
		//when(commentServiceImpl.getAllComments()).thenReturn((List<Comments>) list);
		//List<Comments> commentFromdb = commentsDaoImpl.getAllComments();
		  
		when(commentsDaoImpl.getAllComments()).thenReturn((List<Comments>) list);
		  
		List<Comments> commentFromdb = commentServiceImpl.getAllComments();

		//System.out.println(commentFromdb);
		
		File file = new File("comments_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllCommentsImplTest1="+(commentFromdb==list ? true : false), true); 

		//assertEquals(Collections.EMPTY_LIST, list); 
	}
	 	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testViewAllCommentsImplTest2() throws Exception 
	{ 
		//when(new CommentServiceImpl().getAllComments()).thenReturn(null);
		when(commentsDaoImpl.getAllComments()).thenReturn(null);
		  
		List<Comments> commentFromdb = commentServiceImpl.getAllComments();

		//System.out.println(commentFromdb);

		File file = new File("comments_output_revised.txt");
		FileUtils.write(file, "\ntestViewAllCommentsImplTest2="+(commentFromdb==null ? true : false), true);
		
		//assertEquals(null, list); 
	}
	 	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testSaveCommentsImplTest() throws Exception 
	{
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(true); 
		
		List<Comments> commentFromdb = commentsDaoImpl.getAllComments();
		
		File file = new File("comments_output_revised.txt");
		FileUtils.write(file, "\ntestSaveCommentsImplTest="+(commentFromdb != null ? true : false), true);

		//assertEquals(Boolean.TRUE, true); 
	}
}