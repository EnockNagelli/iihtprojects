package in.GiftCardApp.UtilTestClass;

import in.GiftCardApp.model.Buyer;
import in.GiftCardApp.model.Gift;
import in.GiftCardApp.model.Recipient;

public class MasterData {
	public static Buyer getBuyerDetails() {
		Buyer buyer = new Buyer();
		buyer.setBuyerId(1);
		buyer.setBuyerFirstName("Non");
		buyer.setBuyerLastName("of");
		buyer.setBuyerName("your Buss...");
		buyer.setPassword("1234567890");
		buyer.setBuyerPhoneNo("9876543210");
		buyer.setBuyerEmailId("nonofyourbuss@gmail.com");
		return buyer;
	}
	public static Gift getGiftDetails() {
		Gift gift = new Gift();
		gift.setGiftId(1);
		gift.setGiftName("Flower");
		gift.setGiftCardPrice(100);
		return gift;
	}
	public static Recipient getRecipientDetails() {
		Recipient recipient=new Recipient();
		recipient.setRecipientId(1);
		recipient.setRecipientFirstName("Besta");
		recipient.setRecipientLastName("Shashidhar");
		recipient.setRecipientUserName("B Shashidhar");
		recipient.setRecipientPhoneNo("9494879694");
		recipient.setStreetAddress("Zaheerabad");
		recipient.setCity("Zaheerabad");
		recipient.setState("Telangana");
		recipient.setCountry("India");
		recipient.setPincode("502220");		
		return recipient;
	}

}