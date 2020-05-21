package in.GiftCardApp.service;

import in.GiftCardApp.model.Buyer;

public interface BuyerService {
	int createBuyer(Buyer  buyer);
	Buyer getBuyer(int buyerId);
	boolean updateBuyer(Buyer buyer);
	boolean deleteBuyer(Buyer buyer);	
}
