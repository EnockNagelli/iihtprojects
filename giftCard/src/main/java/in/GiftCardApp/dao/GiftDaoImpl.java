package in.GiftCardApp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.model.Gift;
@Repository
@Transactional
public class GiftDaoImpl implements GiftDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public int createGift(Gift buyer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Gift getGift(int guftId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateGift(Gift gift) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteGift(Gift gift) {
		// TODO Auto-generated method stub
		return false;
	}

}
