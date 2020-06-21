package com.forum.ForumProject.UtilTestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;

public class MasterData 
{
	public static Posts getPostDetails() 
	{
		Posts post = new Posts();
		
		post.setPostId(post.getPostId());
		post.setTitle("Spring Technology");
		post.setTags("Java");
		post.setPostDescription("Used in IT Sector");
		
		return post;
	}
	public static Comments getCommentDetails() 
	{
		Comments comments = new Comments();
		
		comments.setPostId(comments.getPostId());
		comments.setCommentId(comments.getCommentId());
		comments.setTags("I Like it");
		comments.setVisitorComment("Design Patterns are important in Java Technology");
		
		return comments;
	}
	
	public static Properties getProperties() throws IOException 
	{
		FileReader reader = new FileReader("src\\main\\resources\\database.properties");
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	
	public static LocalSessionFactoryBean getSession() throws IOException 
	{
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		Properties properties = getProperties();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan("com.forum.ForumProject.entity");
		
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