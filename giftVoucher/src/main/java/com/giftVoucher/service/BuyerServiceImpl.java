package com.giftVoucher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giftVoucher.dao.BuyerDao;
import com.giftVoucher.model.Buyer;

@Service("BuyerService")
@Transactional(readOnly = true)
public class BuyerServiceImpl implements BuyerService 
{
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
	
	@Override
	public List<Buyer> listUser() {
		// TODO Auto-generated method stub
		List<Buyer> listuser = new ArrayList<Buyer>();
		return listuser;
	}
}