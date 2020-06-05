package in.GiftCardApp.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.google.gson.Gson;

import in.GiftCardApp.UtilTestClass.MasterData;
import in.GiftCardApp.controller.GiftCardController;
import in.GiftCardApp.service.BuyerService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	private BuyerService buyerService;

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

//	@Test
//	public void testViewAllUsersApi() throws Exception {
//		List<Buyer> userList = new ArrayList<>();
//		userList.add(new Buyer());
//		userList.add(new Buyer());
//		when(buyerService.listUser()).thenReturn((List) userList);
//		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk()).andExpect(view().name("ok"));
//	}
//
//	@Test
//	public void testViewAllUsersApiCase1() throws Exception {
//		when(userService.listUser()).thenReturn(null);
//		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk())
//				.andExpect(view().name("No Records Found"));
//	}

	@Test
	public void testSaveUsersApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(buyerService.createBuyer(MasterData.getBuyerDetails())).thenReturn(0);
		this.mockMvc
				.perform(post("/addUser").content(gson.toJson(MasterData.getBuyerDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));

	}
}
