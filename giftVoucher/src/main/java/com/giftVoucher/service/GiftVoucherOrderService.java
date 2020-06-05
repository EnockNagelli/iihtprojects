package com.giftVoucher.service;

import java.util.List;

import com.giftVoucher.entity.GiftVoucherOrderDetails;

/**
 * @author Nagelli Enock
 */

public interface GiftVoucherOrderService 
{
    /**
     * @return list of gift orders
     */
	List<GiftVoucherOrderDetails> getAllOrderDetails();

	/**
	 * @param giftVoucherOrderDetails
	 * @return boolean true for successfully saving
	 */
	Boolean saveGiftVoucherOrderDetail(GiftVoucherOrderDetails giftVoucherOrderDetails);
}