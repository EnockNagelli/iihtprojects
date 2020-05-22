package com.giftVoucher.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.giftVoucher.entity.GiftVoucherOrderDetails;

/**
 * @author Nagelli Enock
 */

@Transactional
@Repository
public class GiftVoucherOrdersDAOImpl implements GiftVoucherOrderDetailsDAO 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<GiftVoucherOrderDetails> getAllOrdersDetails() 
	{
		String hql = "FROM GiftVoucherOrderDetails as g ORDER BY g.orderId";
		return (List<GiftVoucherOrderDetails>) hibernateTemplate.find(hql);
	}

	public void saveOrderDetails(GiftVoucherOrderDetails giftVoucherOrderDetails) 
	{
		hibernateTemplate.save(giftVoucherOrderDetails);
	}
}