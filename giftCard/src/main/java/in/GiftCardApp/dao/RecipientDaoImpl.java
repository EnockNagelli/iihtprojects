package in.GiftCardApp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.GiftCardApp.model.Recipient;
@Repository
@Transactional
public class RecipientDaoImpl implements RecipientDao {
	@Autowired
	private SessionFactory sessionFactory;
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
