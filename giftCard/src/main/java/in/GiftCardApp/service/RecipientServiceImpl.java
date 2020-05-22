package in.GiftCardApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.model.Recipient;
@Service("RecipientService")
@Transactional(readOnly = true)
public class RecipientServiceImpl implements RecipientService {

	public int createRecipient(Recipient recipient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Recipient getRecipient(int recipientId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateRecipient(Recipient recipient) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteRecipient(Recipient recipient) {
		// TODO Auto-generated method stub
		return false;
	}

}
