package com.giftCard.serviceImplTest;

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

import com.giftCard.UtilTestClass.MasterData;
import com.giftCard.dao.GiftCardOrderDetailsDAO;
import com.giftCard.entity.GiftCardOrderDetails;
import com.giftCard.service.GiftCardOrderServiceImpl;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class GiftOrderServiceImplTest {
	
	@Mock
	private GiftCardOrderDetailsDAO giftCardOrderDetailsDAO;

	@InjectMocks
	private GiftCardOrderServiceImpl giftCardOrderServiceImpl;

	//private MockMvc mockMvc;
	
	@Test
	public void testViewAllOrdersImplTest() throws Exception {
		List<GiftCardOrderDetails> giftOrderList = new ArrayList<>();
		giftOrderList.add(new GiftCardOrderDetails());
		giftOrderList.add(new GiftCardOrderDetails());
		when(giftCardOrderDetailsDAO.getAllOrdersDetails()).thenReturn((List<GiftCardOrderDetails>) giftOrderList);
		List<GiftCardOrderDetails> list =giftCardOrderServiceImpl.getAllOrderDetails();
	    assertEquals(2, list.size());
	}
	
	@Test
	public void testViewAllOrdersImplTest1() throws Exception {
		List<GiftCardOrderDetails> giftOrderList = new ArrayList<>();
		when(giftCardOrderDetailsDAO.getAllOrdersDetails()).thenReturn((List<GiftCardOrderDetails>) giftOrderList);
		List<GiftCardOrderDetails> list =giftCardOrderServiceImpl.getAllOrderDetails();
	    assertEquals(Collections.EMPTY_LIST, list);
	}
	
	@Test
	public void testViewAllOrdersImplTest2() throws Exception {
		when(giftCardOrderDetailsDAO.getAllOrdersDetails()).thenReturn(null);
		List<GiftCardOrderDetails> list =giftCardOrderServiceImpl.getAllOrderDetails();
	    assertEquals(null, list);
	}
	
	@Test
	public void testSaveOrdersImplTest() throws Exception {
		Boolean value = giftCardOrderServiceImpl.saveGiftCardOrderDetail(MasterData.getDetails());
		assertEquals(Boolean.TRUE, value);
	}
}
