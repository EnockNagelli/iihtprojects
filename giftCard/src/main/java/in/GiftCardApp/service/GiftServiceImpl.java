package in.GiftCardApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.model.Gift;
@Service("GiftService")
@Transactional(readOnly = true)
public class GiftServiceImpl implements GiftService {

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
