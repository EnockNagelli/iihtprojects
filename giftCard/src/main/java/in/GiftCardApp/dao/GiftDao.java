package in.GiftCardApp.dao;

import in.GiftCardApp.model.Gift;

public interface GiftDao {
	int createGift(Gift  gift);
	Gift getGift(int guftId);
	boolean updateGift(Gift gift);
	boolean deleteGift(Gift gift);	
}
