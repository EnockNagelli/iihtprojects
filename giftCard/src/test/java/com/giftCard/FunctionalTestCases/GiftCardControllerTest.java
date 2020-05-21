package com.giftCard.FunctionalTestCases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.giftCard.UtilTestClass.MasterData;
import com.giftCard.controller.GiftCardController;
import com.giftCard.entity.GiftCardOrderDetails;
//import com.giftCard.entity.ShippingAddress;
import com.giftCard.service.GiftCardOrderService;
import com.google.gson.Gson;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class GiftCardControllerTest {

	@Mock
	private GiftCardOrderService giftCardOrderService;

	@InjectMocks
	private GiftCardController giftCardController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(giftCardController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testRegisterUser() throws Exception {
		
	}

	@Test
	public void testRegisterUserBuyer() throws Exception {
		
	}

	@Test
	public void testRegisterUserRecipient() throws Exception {
		
	}
	
	@Test
	public void testLoginUser() throws Exception {
		
	}

	@Test
	public void testLoginUserBuyer() throws Exception {
		
	}

	@Test
	public void testLoginUserRecipent() throws Exception {
		
	}
	
	@Test
	public void testDeliveryStatus() throws Exception {
		
	}

	@Test
	public void testCommissionReport() throws Exception {
		
	}
	
	@Test
	public void testViewAllOrdersApi() throws Exception {
		List<GiftCardOrderDetails> giftOrderList = new ArrayList<>();
		giftOrderList.add(new GiftCardOrderDetails());
		giftOrderList.add(new GiftCardOrderDetails());
		when(giftCardOrderService.getAllOrderDetails()).thenReturn((List<GiftCardOrderDetails>) giftOrderList);
		this.mockMvc.perform(get("/viewAllOrders")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}

	@Test
	public void testViewAllOrdersApiCase1() throws Exception {
		when(giftCardOrderService.getAllOrderDetails()).thenReturn(null);
		this.mockMvc.perform(get("/viewAllOrders")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}
	
	@Test
	public void testSaveOrdersApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/addGiftCardOrder").content(gson.toJson(MasterData.getDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));
	}
}