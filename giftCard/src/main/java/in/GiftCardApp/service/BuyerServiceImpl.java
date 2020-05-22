package in.GiftCardApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.dao.BuyerDao;
import in.GiftCardApp.model.Buyer;
@Service("BuyerService")
@Transactional(readOnly = true)
public class BuyerServiceImpl implements BuyerService {
	@Autowired(required = true)
	private BuyerDao buyerDao;
	public int createBuyer(Buyer buyer) {
		return 0;
		
	}

	public Buyer getBuyer(int buyerId) {
		return null;
		
	}

	public boolean updateBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		return false;
	}

}
