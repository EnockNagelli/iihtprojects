package com.forum.ForumProject.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.service.CommentServiceImpl;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestCommentServiceImpl 
{
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;
	
	@Test
	public void testCommentServiceImplTest() throws Exception 
	{
		commentServiceImpl.saveComment(MasterData.getCommentDetails());
		assertEquals(Boolean.TRUE, true);
	}
	
	@Test
	public void testViewAllCommentsImplTest() throws Exception 
	{
		List<Comments> comments = new ArrayList<Comments>();
					
		when(new CommentServiceImpl().getAllComments()).thenReturn((List<Comments>) comments);
		
		List<Comments> list = commentServiceImpl.getAllComments();
		
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewAllCommentsImplTest1() throws Exception 
	{
		List<Comments> comments = new ArrayList<Comments>();
		
		when(new CommentServiceImpl().getAllComments()).thenReturn((List<Comments>) comments);
		
		List<Comments> list = commentServiceImpl.getAllComments();
	    
		assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllCommentsImplTest2() throws Exception 
	{
		when(new CommentServiceImpl().getAllComments()).thenReturn(null);
	
		List<Comments> list = commentServiceImpl.getAllComments();
	    
		assertEquals(null, list);
	}
	
	@Test
	public void testSaveCommentsImplTest() throws Exception 
	{
		when(commentServiceImpl.saveComment(MasterData.getCommentDetails())).thenReturn(true);
		assertEquals(Boolean.TRUE, true);
	}	
}