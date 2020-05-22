package com.giftVoucher.serviceImplTest;

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
//import org.springframework.test.web.servlet.MockMvc;

import com.giftVoucher.dao.GiftVoucherOrderDetailsDAO;
import com.giftVoucher.entity.GiftVoucherOrderDetails;
import com.giftVoucher.service.GiftVoucherOrderServiceImpl;
import com.giftVoucher.dao.BuyerDao;
import com.giftVoucher.dao.GiftDao;
import com.giftVoucher.dao.RecipientDao;
import com.giftVoucher.model.Buyer;
import com.giftVoucher.model.Gift;
import com.giftVoucher.model.Recipient;
import com.giftVoucher.service.BuyerServiceImpl;
import com.giftVoucher.service.GiftServiceImpl;
import com.giftVoucher.service.RecipientServiceImpl;

import com.giftVoucher.UtilTestClass.MasterData;

/**
 * @author Nagelli Enock
 */

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class GiftOrderServiceImplTest 
{
	//----------------------------------------------------------------------------
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
	//----------------------------------------------------------------------------
	@Mock
	private GiftVoucherOrderDetailsDAO giftVoucherOrderDetailsDAO;

	@InjectMocks
	private GiftVoucherOrderServiceImpl giftVoucherOrderServiceImpl;

	//private MockMvc mockMvc;
	//----------------------------------------------------------------------------
	@Test
	public void testViewAllOrdersImplTest() throws Exception 
	{
		List<GiftVoucherOrderDetails> giftOrderList = new ArrayList<>();
		giftOrderList.add(new GiftVoucherOrderDetails());
		giftOrderList.add(new GiftVoucherOrderDetails());
		when(giftVoucherOrderDetailsDAO.getAllOrdersDetails()).thenReturn((List<GiftVoucherOrderDetails>) giftOrderList);
		List<GiftVoucherOrderDetails> list =giftVoucherOrderServiceImpl.getAllOrderDetails();
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewAllOrdersImplTest1() throws Exception 
	{
		List<GiftVoucherOrderDetails> giftOrderList = new ArrayList<>();
		when(giftVoucherOrderDetailsDAO.getAllOrdersDetails()).thenReturn((List<GiftVoucherOrderDetails>) giftOrderList);
		List<GiftVoucherOrderDetails> list =giftVoucherOrderServiceImpl.getAllOrderDetails();
	    assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllOrdersImplTest2() throws Exception {
		when(giftVoucherOrderDetailsDAO.getAllOrdersDetails()).thenReturn(null);
		List<GiftVoucherOrderDetails> list = giftVoucherOrderServiceImpl.getAllOrderDetails();
	    assertEquals(null, list);
	}
	
	@Test
	public void testSaveOrdersImplTest() throws Exception {
		Boolean value = giftVoucherOrderServiceImpl.saveGiftVoucherOrderDetail(MasterData.getDetails());
		assertEquals(Boolean.TRUE, value);
	}
	//----------------------------------------------------------------------------
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