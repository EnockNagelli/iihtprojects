package in.GiftCardApp.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.test.web.servlet.MockMvc;

import in.GiftCardApp.UtilTestClass.MasterData;
import in.GiftCardApp.dao.BuyerDao;
import in.GiftCardApp.dao.GiftDao;
import in.GiftCardApp.dao.RecipientDao;
import in.GiftCardApp.model.Buyer;
import in.GiftCardApp.model.Gift;
import in.GiftCardApp.model.Recipient;
import in.GiftCardApp.service.BuyerServiceImpl;
import in.GiftCardApp.service.GiftServiceImpl;
import in.GiftCardApp.service.RecipientServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserRegiServiceImplTest {

	@Mock
	private BuyerDao buyerDao;
	@Mock
	private GiftDao giftDao;
	@Mock
	private RecipientDao recipientDao;

	@Mock
	private Buyer buyer;
	@Mock
	private Gift gift;
	@Mock
	private Recipient recipient;

	@InjectMocks
	private BuyerServiceImpl buyerServiceImpl;
	
	@InjectMocks
	private GiftServiceImpl giftServiceImpl;
	
	@InjectMocks
	private RecipientServiceImpl recipientServiceImpl;

	//private MockMvc mockMvc;

	@Test
	public void testSaveBuyerImplTest() throws Exception {
		int value = buyerServiceImpl.createBuyer(MasterData.getBuyerDetails());
		assertEquals(Boolean.TRUE, value);
	}
	@Test
	public void testSaveGiftImplTest() throws Exception {
		int value = giftServiceImpl.createGift(MasterData.getGiftDetails());
		assertEquals(Boolean.TRUE, value);
	}
	@Test
	public void testRecipientGiftImplTest() throws Exception {
		int value = recipientServiceImpl.createRecipient(MasterData.getRecipientDetails());
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
	public void testDeleteBuyerImplTest() throws Exception {
		Buyer buyer = buyerServiceImpl.getBuyer(MasterData.getBuyerDetails().getBuyerId());
		when(buyerDao.getBuyer(1)).thenReturn(buyer).thenReturn(null);
		Buyer res = buyerServiceImpl.getBuyer(1);
		assertEquals(null, res);
	}
	@Test
	public void testDeleteGiftImplTest() throws Exception {
		Buyer buyer = buyerServiceImpl.getBuyer(MasterData.getBuyerDetails().getBuyerId());
		when(buyerDao.getBuyer(1)).thenReturn(buyer).thenReturn(null);
		Buyer res = buyerServiceImpl.getBuyer(1);
		assertEquals(null, res);
	}
	@Test
	public void testDeleteRecipientImplTest() throws Exception {
		Recipient recipient = recipientServiceImpl.getRecipient(MasterData.getRecipientDetails().getRecipientId());
		when(recipientDao.getRecipient(1)).thenReturn(recipient).thenReturn(null);
		Recipient res = recipientServiceImpl.getRecipient(1);
		assertEquals(null, res);
	}
}