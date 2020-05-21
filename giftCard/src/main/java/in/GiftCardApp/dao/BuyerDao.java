package in.GiftCardApp.dao;

import in.GiftCardApp.model.Buyer;

public interface BuyerDao {
	int createBuyer(Buyer  buyer);
	Buyer getBuyer(int buyerId);
	boolean updateBuyer(Buyer buyer);
	boolean deleteBuyer(Buyer buyer);	
}
