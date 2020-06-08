package com.forum.ForumProject.UtilTestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.DiscussionTitles;
import com.forum.forumProject.entity.Posts;

public class MasterData 
{
	public static Posts getPostDetails() 
	{
		Posts post = new Posts();
		
		post.setPostId(post.getPostId());
		post.setTitle("Technology");
		post.setTags("Tag1");
		post.setPostDescription("Post Description : Technology is useful for better human lifes...");
		
		return post;
	}
	public static Comments getCommentDetails() 
	{
		Comments comments = new Comments();
		
		comments.setCommentId(comments.getCommentId());
		comments.setTags("Tag @ Comments");
		comments.setVisitorComment("Need to explore IT world to better understand Computers");
		
		return comments;
	}
	
	public static DiscussionTitles getDiscussionDetails() 
	{
		DiscussionTitles discuss = new DiscussionTitles();
		
		discuss.setTitleId(discuss.getTitleId());
		discuss.setDiscussionTitle("Discussion Title 1");
		
		return discuss;
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
		
		//BasicDataSource dataSource = new BasicDataSource();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan("com.forum.ForumApp.entity");
		
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