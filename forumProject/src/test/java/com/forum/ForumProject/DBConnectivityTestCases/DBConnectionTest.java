package com.forum.ForumProject.DBConnectivityTestCases;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.entity.*;

public class DBConnectionTest 
{
	@Test
	public void testConnectivity() throws IOException 
	{
		Properties properties = MasterData.getProperties();
		//BasicDataSource dataSource = new BasicDataSource();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

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
	public void testSqlException() throws IOException 
	{
		HibernateTemplate  session = new HibernateTemplate( MasterData.getSession().getObject());
		String hql = "FROM Posts";
		
		@SuppressWarnings("unchecked")
		List<Posts> size = (List<Posts>) session.find(hql);
		assertNotNull(size);
	}
}