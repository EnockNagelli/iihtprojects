package com.giftVoucher.service;

import java.util.List;

import com.giftVoucher.model.Buyer;

public interface BuyerService 
{
	int createBuyer(Buyer buyer);
	Buyer getBuyer(int buyerId);
	boolean updateBuyer(Buyer buyer);
	boolean deleteBuyer(Buyer buyer);
	List<Buyer> listUser();
}