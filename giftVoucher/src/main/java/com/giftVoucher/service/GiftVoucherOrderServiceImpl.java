package com.giftVoucher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giftVoucher.dao.GiftVoucherOrderDetailsDAO;
import com.giftVoucher.entity.GiftVoucherOrderDetails;

/**
 * @author Nagelli Enock
 */

@Service
public class GiftVoucherOrderServiceImpl implements GiftVoucherOrderService 
{
	@Autowired
	private GiftVoucherOrderDetailsDAO giftVoucherOrderDetailsDAO;

	public List<GiftVoucherOrderDetails> getAllOrderDetails() {
		return giftVoucherOrderDetailsDAO.getAllOrdersDetails();
	}

	public Boolean saveGiftVoucherOrderDetail(GiftVoucherOrderDetails giftVoucherOrderDetails) {
		try {
			giftVoucherOrderDetailsDAO.saveOrderDetails(giftVoucherOrderDetails);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}