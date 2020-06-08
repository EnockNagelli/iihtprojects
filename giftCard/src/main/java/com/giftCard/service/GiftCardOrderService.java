package com.giftCard.service;

import java.util.List;

import com.giftCard.entity.GiftCardOrderDetails;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

public interface GiftCardOrderService {
	
    /**
     * 
     * @return list of gift orders
     */
	List<GiftCardOrderDetails> getAllOrderDetails();

	/**
	 * 
	 * @param giftCardOrderDetails
	 * @return boolean true for successfully saving
	 */
	Boolean saveGiftCardOrderDetail(GiftCardOrderDetails giftCardOrderDetails);
}