package in.GiftCardApp.dao;

import in.GiftCardApp.model.Recipient;

public interface RecipientDao {
	int createRecipient(Recipient  recipient);
	Recipient getRecipient(int recipientId);
	boolean updateRecipient(Recipient recipient);
	boolean deleteRecipient(Recipient recipient);	
}
