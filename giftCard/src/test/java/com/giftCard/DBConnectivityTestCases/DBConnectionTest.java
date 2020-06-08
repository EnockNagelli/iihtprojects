package com.giftCard.DBConnectivityTestCases;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.giftCard.UtilTestClass.MasterData;
import com.giftCard.entity.GiftCardOrderDetails;

public class DBConnectionTest 
{
	@Test
	public void testConnectivity() throws IOException {
		Properties properties = MasterData.getProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		assertNotNull(dataSource);
	}

	@Test
	public void hibernateProperties() throws IOException {
		Properties properties = MasterData.getProperties();
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
	}

	@Test
	public void testSqlException() throws IOException {
		
		HibernateTemplate  session = new HibernateTemplate( MasterData.getSession().getObject());
		String hql = "FROM GiftCardOrderDetails";
		@SuppressWarnings("unchecked")
		List<GiftCardOrderDetails> size = (List<GiftCardOrderDetails>) session.find(hql);
		assertNotNull(size);
	}
}