package com.giftVoucher.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.giftVoucher.entity.GiftVoucherOrderDetails;
import com.giftVoucher.service.GiftVoucherOrderService;

/**
 * @author Nagelli Enock
 */

@Controller
public class GiftVoucherController {

	@Autowired
	private GiftVoucherOrderService giftVoucherOrderService;

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
	
	@RequestMapping(value = "/addGiftVoucherOrder", method = RequestMethod.POST)
	public String addGiftOrder(@RequestBody @Valid GiftVoucherOrderDetails giftVoucherOrderDetails) 
	{
			Boolean value = giftVoucherOrderService.saveGiftVoucherOrderDetail(giftVoucherOrderDetails);
			if(value) {
				return "ok";
			}
			return "record not saved";
	}

	@RequestMapping(value = "/viewAllOrders", method = RequestMethod.GET)
	public String viewAllOrders()
	{
		try {
			List<GiftVoucherOrderDetails> giftOrderList = giftVoucherOrderService.getAllOrderDetails();
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