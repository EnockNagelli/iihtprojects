package in.GiftCardApp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.model.Buyer;
@Repository
@Transactional
public class BuyerDaoImpl implements BuyerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

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
