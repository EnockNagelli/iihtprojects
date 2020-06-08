package com.giftCard.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.giftCard.entity.GiftCardOrderDetails;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@Transactional
@Repository
public class GiftCardOrdersDAOImpl implements GiftCardOrderDetailsDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<GiftCardOrderDetails> getAllOrdersDetails() {
		String hql = "FROM GiftCardOrderDetails as g ORDER BY g.orderId";
		return (List<GiftCardOrderDetails>) hibernateTemplate.find(hql);

	}

	public void saveOrderDetails(GiftCardOrderDetails giftCardOrderDetails) {
		hibernateTemplate.save(giftCardOrderDetails);
	}
}