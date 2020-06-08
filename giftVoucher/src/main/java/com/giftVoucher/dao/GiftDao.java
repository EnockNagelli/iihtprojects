package com.giftVoucher.dao;

import com.giftVoucher.model.Gift;

public interface GiftDao 
{
	int createGift(Gift  gift);
	Gift getGift(int guftId);
	boolean updateGift(Gift gift);
	boolean deleteGift(Gift gift);	
}