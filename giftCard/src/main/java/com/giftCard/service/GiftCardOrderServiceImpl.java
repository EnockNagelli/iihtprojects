package com.giftCard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giftCard.dao.GiftCardOrderDetailsDAO;
import com.giftCard.entity.GiftCardOrderDetails;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@Service
public class GiftCardOrderServiceImpl implements GiftCardOrderService {

	@Autowired
	private GiftCardOrderDetailsDAO giftCardOrderDetailsDAO;

	public List<GiftCardOrderDetails> getAllOrderDetails() {
		return giftCardOrderDetailsDAO.getAllOrdersDetails();
	}

	public Boolean saveGiftCardOrderDetail(GiftCardOrderDetails giftCardOrderDetails) {
		try {
			giftCardOrderDetailsDAO.saveOrderDetails(giftCardOrderDetails);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}