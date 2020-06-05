package com.forum.ForumApp.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.test.web.servlet.MockMvc;

import com.forum.ForumApp.UtilTestClass.MasterData;
import com.forum.ForumApp.dao.CommentsDao;
import com.forum.ForumApp.dao.DiscussionListDao;
import com.forum.ForumApp.dao.PostDao;
import com.forum.ForumApp.entity.Comments;
import com.forum.ForumApp.entity.DiscussionList;
import com.forum.ForumApp.entity.Posts;
import com.forum.ForumApp.services.impl.CommentServiceImpl;
import com.forum.ForumApp.services.impl.PostServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

	@Mock
	private PostDao postDao;
	@Mock
	private CommentsDao commentsDao;
	@Mock
	private DiscussionListDao discussionListDao;

	@Mock
	private Posts posts;
	@Mock
	private Comments comments;
	@Mock
	private DiscussionList discussionList;

	@InjectMocks
	private PostServiceImpl postServiceImpl;
	
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;
	
	//private MockMvc mockMvc;

	@Test
	public void testCommentServiceImplTest() throws Exception 
	{
		boolean value = commentServiceImpl.saveComment(MasterData.getCommentDetails());
		assertEquals(Boolean.TRUE, value);
	}
	
	@Test
	public void testPostServiceImplTest() throws Exception 
	{
		boolean value = postServiceImpl.savePost(MasterData.getPostDetails());
		assertEquals(Boolean.TRUE, value);
	}
	
	@Test
	public void testGetBuyerImplTest() throws Exception {
		buyer = buyerServiceImpl.getBuyer(MasterData.getBuyerDetails().getBuyerId());
		when(buyerDao.getBuyer(1)).thenReturn(null);
		Buyer res = buyerServiceImpl.getBuyer(1);
		assertEquals(null, res);
	}
	@Test
	public void testGetGiftImplTest() throws Exception {
		gift = giftServiceImpl.getGift(MasterData.getGiftDetails().getGiftId());
		when(giftDao.getGift(1)).thenReturn(null);
		Gift res = giftServiceImpl.getGift(1);
		assertEquals(null, res);
	}
	@Test
	public void testGetRecipientImplTest() throws Exception {
		recipient = recipientServiceImpl.getRecipient(MasterData.getRecipientDetails().getRecipientId());
		when(recipientDao.getRecipient(1)).thenReturn(null);
		Recipient res = recipientServiceImpl.getRecipient(1);
		assertEquals(null, res);
	}

//	@Test
//	public void testViewAllUsersImplTest() throws Exception {
//		List<User> userList = new ArrayList<>();
//		userList.add(new User());
//		userList.add(new User());
//		when(userDao.listUser()).thenReturn((List) userList);
//		List<User> list = userServiceImp.listUser();
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testViewAllUsersImplTest1() throws Exception {
//		List<User> userList = new ArrayList<>();
//		when(userDao.listUser()).thenReturn((List) userList);
//		List<User> list = userServiceImp.listUser();
//		assertEquals(Collections.EMPTY_LIST, list);
//	}

//	@Test
//	public void testViewAllUsersImplTest2() throws Exception {
//		when(userDao.listUser()).thenReturn(null);
//		List<User> list = userServiceImp.listUser();
//		assertEquals(null, list);
//	}
	
	@Test
	public void testDeleteBuyerImplTest() throws Exception 
	{
		Buyer buyer = buyerServiceImpl.getBuyer(MasterData.getBuyerDetails().getBuyerId());
		when(buyerDao.getBuyer(1)).thenReturn(buyer).thenReturn(null);
		Buyer res = buyerServiceImpl.getBuyer(1);
		assertEquals(null, res);
	}
	
	@Test
	public void testDeleteGiftImplTest() throws Exception 
	{
		Buyer buyer = buyerServiceImpl.getBuyer(MasterData.getBuyerDetails().getBuyerId());
		when(buyerDao.getBuyer(1)).thenReturn(buyer).thenReturn(null);
		Buyer res = buyerServiceImpl.getBuyer(1);
		assertEquals(null, res);
	}
	
	@Test
	public void testDeleteRecipientImplTest() throws Exception 
	{
		Recipient recipient = recipientServiceImpl.getRecipient(MasterData.getRecipientDetails().getRecipientId());
		when(recipientDao.getRecipient(1)).thenReturn(recipient).thenReturn(null);
		Recipient res = recipientServiceImpl.getRecipient(1);
		assertEquals(null, res);
	}
}