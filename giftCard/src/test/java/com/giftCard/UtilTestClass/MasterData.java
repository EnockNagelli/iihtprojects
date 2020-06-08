package com.giftCard.UtilTestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.giftCard.entity.GiftCardOrderDetails;
import com.giftCard.entity.ShippingAddress;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
public class MasterData {

	public static GiftCardOrderDetails getDetails() {

		GiftCardOrderDetails orderDetails = new GiftCardOrderDetails();
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
	
	public static Properties getProperties() throws IOException {
		FileReader reader = new FileReader("src\\main\\resources\\database.properties");
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	
	public static LocalSessionFactoryBean getSession() throws IOException {
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
