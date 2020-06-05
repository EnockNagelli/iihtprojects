package com.giftVoucher.dao;

import com.giftVoucher.model.Recipient;

public interface RecipientDao
{
	int createRecipient(Recipient  recipient);
	Recipient getRecipient(int recipientId);
	boolean updateRecipient(Recipient recipient);
	boolean deleteRecipient(Recipient recipient);	
}