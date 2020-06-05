package com.giftVoucher.dao;

import java.util.List;

import com.giftVoucher.entity.GiftVoucherOrderDetails;

/**
 * @author Nagelli Enock
 */
public interface GiftVoucherOrderDetailsDAO {
	
	List<GiftVoucherOrderDetails> getAllOrdersDetails();

	void saveOrderDetails(GiftVoucherOrderDetails giftVoucherOrderDetails);
}