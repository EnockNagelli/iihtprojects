package com.giftVoucher.UtilTestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.giftVoucher.entity.GiftVoucherOrderDetails;
import com.giftVoucher.entity.ShippingAddress;
import com.giftVoucher.model.Buyer;
import com.giftVoucher.model.Gift;
import com.giftVoucher.model.Recipient;

/**
 * @author Nagelli Enock
 */
public class MasterData {

	public static GiftVoucherOrderDetails getDetails() 
	{
		GiftVoucherOrderDetails orderDetails = new GiftVoucherOrderDetails();
		orderDetails.setBuyerFirstName("buyerFirstName");
		orderDetails.setBuyerLastName("buyerLastName");
		orderDetails.setEmail("email@gmail.com");
		double amount = 100.50;
		orderDetails.setGiftAmount((long) amount);
		orderDetails.setPhoneNumber("9010893970");
		orderDetails.setRecipienLastName("recepientName");
		orderDetails.setRecipientFirstName("recipientFirstName");

		ShippingAddress shippingDetails = new ShippingAddress();
		shippingDetails.setCityName("cityName");
		shippingDetails.setCountry("country");
		shippingDetails.setPincode("pincode");
		shippingDetails.setState("state");
		shippingDetails.setStreetName("streetName");
		orderDetails.setShippingId(shippingDetails);
		return orderDetails;
	}
	
	public static Properties getProperties() throws IOException 
	{
		FileReader reader = new FileReader("src\\main\\resources\\database.properties");
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	
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
	
	public static LocalSessionFactoryBean getSession() throws IOException 
	{
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		
		Properties properties = getProperties();
	
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		lsfb.setDataSource(dataSource);
		
		lsfb.setPackagesToScan("com.giftCard.entity");
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		lsfb.setHibernateProperties(properties);
		
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb;
	}	
}