package com.forum.forumProject.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.forum.forumProject")
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	//------------------------------------------------------------------------------------------------------------------------
	/*
	 * @Override public Validator getValidator() { LocalValidatorFactoryBean
	 * validator = new LocalValidatorFactoryBean();
	 * validator.setValidationMessageSource(messageSource()); return validator; }
	 * 
	 * @Bean public MessageSource messageSource() { ResourceBundleMessageSource
	 * source = new ResourceBundleMessageSource(); source.setBasename("messages");
	 * return source; }
	 */
}