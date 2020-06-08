package com.giftVoucher.service;

import com.giftVoucher.model.Gift;

public interface GiftService 
{
	int createGift(Gift  buyer);
	Gift getGift(int guftId);
	boolean updateGift(Gift gift);
	boolean deleteGift(Gift gift);	
}
