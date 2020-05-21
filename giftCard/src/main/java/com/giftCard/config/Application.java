package com.giftCard.config;

import java.io.File;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
public class Application {
    public static void main(String[] args) throws Exception {

        String webAppDirLocation = "src/main/";
        Tomcat tomcat = new Tomcat();

        //Set Port #
        tomcat.setPort(9500);

        @SuppressWarnings("unused")
		StandardContext ctx = (StandardContext) tomcat.addWebapp("/giftCard", new File(webAppDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}