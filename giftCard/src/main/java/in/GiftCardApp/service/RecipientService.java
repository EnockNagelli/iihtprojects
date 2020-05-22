package in.GiftCardApp.service;

import in.GiftCardApp.model.Recipient;

public interface RecipientService {
	int createRecipient(Recipient  recipient);
	Recipient getRecipient(int recipientId);
	boolean updateRecipient(Recipient recipient);
	boolean deleteRecipient(Recipient recipient);	
}
