package com.forum.ForumApp.serviceImplTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.forum.ForumApp.UtilTestClass.MasterData;
import com.forum.ForumApp.services.impl.CommentServiceImpl;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest 
{
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;
	
	//private MockMvc mockMvc;

	@Test
	public void testCommentServiceImplTest() throws Exception 
	{
		boolean value = commentServiceImpl.saveComment(MasterData.getCommentDetails());
		assertEquals(Boolean.TRUE, value);
	}
}