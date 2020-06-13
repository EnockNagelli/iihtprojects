package com.forum.ForumProject.DBConnectivityTestCases;

//import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.entity.Posts;

public class TestDBConnection 
{
	static 
	{
		File file = new File("db_output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("db_output_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testConnectivity() throws IOException 
	{
		boolean value = false;
		
		Properties properties = MasterData.getProperties();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));		
		
	    if(dataSource != null)
	    	value = true;

	    File file = new File("db_output_revised.txt");
	    FileUtils.write(file, "testConnectivity="+(value ? true : false), true); 

	    //assertNotNull(dataSource);
	}

	@Test
	public void hibernateProperties() throws IOException 
	{
		boolean value = false;
		
		Properties properties = MasterData.getProperties();
		
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		
		if(properties != null)
			value = true;

	    File file = new File("db_output_revised.txt");
	    FileUtils.write(file, "\nhibernateProperties="+(value ? true : false), true); 
	}

	
	@SuppressWarnings("unchecked")
	@Test 
	public void testSqlException() throws IOException 
	{ 
		boolean value = false;
		
		HibernateTemplate session = new HibernateTemplate(MasterData.getSession().getObject()); 
		String hql = "FROM Posts";
	  
		List<Posts> size = (List<Posts>) session.find(hql); 

		if(size != null)
			value = true;
		
		File file = new File("db_output_revised.txt");
		FileUtils.write(file, "\ntestSqlException="+(value ? true : false), true); 

		//assertNotNull(size);
	}
}