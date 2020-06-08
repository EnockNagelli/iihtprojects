package com.giftVoucher.dao;

import com.giftVoucher.model.Buyer;

public interface BuyerDao 
{
	int createBuyer(Buyer  buyer);
	Buyer getBuyer(int buyerId);
	boolean updateBuyer(Buyer buyer);
	boolean deleteBuyer(Buyer buyer);	
}
