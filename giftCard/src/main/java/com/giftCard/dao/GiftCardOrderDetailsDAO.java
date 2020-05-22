package com.giftCard.dao;

import java.util.List;

import com.giftCard.entity.GiftCardOrderDetails;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
public interface GiftCardOrderDetailsDAO {
	
	List<GiftCardOrderDetails> getAllOrdersDetails();

	void saveOrderDetails(GiftCardOrderDetails giftCardOrderDetails);
}