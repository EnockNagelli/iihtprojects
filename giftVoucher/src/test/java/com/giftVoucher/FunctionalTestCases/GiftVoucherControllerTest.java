package com.giftVoucher.FunctionalTestCases;

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

import com.giftVoucher.controller.GiftVoucherController;
import com.giftVoucher.entity.GiftVoucherOrderDetails;
//import com.giftVoucher.entity.ShippingAddress;
import com.giftVoucher.service.GiftVoucherOrderService;
import com.giftVoucher.UtilTestClass.MasterData;
import com.google.gson.Gson;

/**
 * @author Nagelli Enock
 */

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class GiftVoucherControllerTest {

	@Mock
	private GiftVoucherOrderService giftVoucherOrderService;

	@InjectMocks
	private GiftVoucherController giftVoucherController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(giftVoucherController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	/**
	 * This test is to perform whether the new user is Registered or not 
	 * @throws Exception
	 */
	@Test
	public void testRegisterUser() throws Exception {
		this.mockMvc.perform(get("/registerUser")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}

	@Test
	public void testRegisterUserBuyer() throws Exception {
		this.mockMvc.perform(get("/registerUserBuyer")).andExpect(status().isOk()).andExpect(view().name("ok"));		
	}

	@Test
	public void testRegisterUserRecipient() throws Exception {
		this.mockMvc.perform(get("/registerUserRecipient")).andExpect(status().isOk()).andExpect(view().name("ok"));		
	}
	
	/**
	 * This test is to perform whether the login user is autherized or not 
	 * @throws Exception
	 */
	@Test
	public void testLoginUser() throws Exception {
		this.mockMvc.perform(get("/loginUser")).andExpect(status().isOk()).andExpect(view().name("ok"));		
	}

	@Test
	public void testLoginUserBuyer() throws Exception {
		this.mockMvc.perform(get("/loginUserBuyer")).andExpect(status().isOk()).andExpect(view().name("ok"));		
		
	}

	@Test
	public void testLoginUserRecipient() throws Exception {
		this.mockMvc.perform(get("/loginUserRecipient")).andExpect(status().isOk()).andExpect(view().name("ok"));				
	}
	
	/**
	 * This test is to check the delivery status of the Recipient 
	 * @throws Exception
	 */
	@Test
	public void testDeliveryStatus() throws Exception {
		this.mockMvc.perform(get("/deliveryStatus")).andExpect(status().isOk()).andExpect(view().name("ok"));				
	}

	/**
	 * This test is to check the commission obtained for the services or not
	 * @throws Exception
	 */
	@Test
	public void testCommissionReport() throws Exception {
		this.mockMvc.perform(get("/commissionReport")).andExpect(status().isOk()).andExpect(view().name("ok"));				
	}
	
	@Test
	public void testViewAllOrdersApi() throws Exception {
		List<GiftVoucherOrderDetails> giftOrderList = new ArrayList<>();
		giftOrderList.add(new GiftVoucherOrderDetails());
		giftOrderList.add(new GiftVoucherOrderDetails());
		when(giftVoucherOrderService.getAllOrderDetails()).thenReturn((List<GiftVoucherOrderDetails>) giftOrderList);
		this.mockMvc.perform(get("/viewAllOrders")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}

	@Test
	public void testViewAllOrdersApiCase1() throws Exception {
		when(giftVoucherOrderService.getAllOrderDetails()).thenReturn(null);
		this.mockMvc.perform(get("/viewAllOrders")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}
	
	@Test
	public void testSaveOrdersApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(giftVoucherOrderService.saveGiftVoucherOrderDetail(MasterData.getDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/addGiftVoucherOrder").content(gson.toJson(MasterData.getDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));
	}
}