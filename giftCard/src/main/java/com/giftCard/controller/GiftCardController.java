package com.giftCard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.giftCard.entity.GiftCardOrderDetails;
import com.giftCard.service.GiftCardOrderService;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@Controller
public class GiftCardController {

	@Autowired
	private GiftCardOrderService giftCardOrderService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public void registerUser() {

	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public void loginUser() {

	}
	
	@RequestMapping(value = "/updateDeliveryOrder", method = RequestMethod.POST)
	public void updateDeliveryStatus() {

	}
	
	@RequestMapping(value = "/commissionReport", method = RequestMethod.POST)
	public void generateCommissionReport() {
	
	}	 
	
	@RequestMapping(value = "/addGiftCardOrder", method = RequestMethod.POST)
	public String addGiftOrder(@RequestBody @Valid GiftCardOrderDetails giftCardOrderDetails) {
			Boolean value = giftCardOrderService.saveGiftCardOrderDetail(giftCardOrderDetails);
			if(value) {
				return "ok";
			}
			return "record not saved";
	}

	@RequestMapping(value = "/viewAllOrders", method = RequestMethod.GET)
	public String viewAllOrders() {
		try {
			List<GiftCardOrderDetails> giftOrderList = giftCardOrderService.getAllOrderDetails();
			if(!CollectionUtils.isEmpty(giftOrderList)) {
				return "ok";
			}
			throw new RuntimeException("No Records Found");
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage() {
		return "ok";
	}
}