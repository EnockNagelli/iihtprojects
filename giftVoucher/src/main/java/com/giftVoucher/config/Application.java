package com.giftVoucher.config;

import java.io.File;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Nagelli Enock
 */

public class Application 
{
    public static void main(String[] args) throws Exception 
    {
        String webAppDirLocation = "src/main/";
        Tomcat tomcat = new Tomcat();

        //Set Port #
        tomcat.setPort(9600);

        @SuppressWarnings("unused")
		StandardContext ctx = (StandardContext) tomcat.addWebapp("/giftVoucher", new File(webAppDirLocation).getAbsolutePath());

        tomcat.start();
        
        tomcat.getServer().await();
    }
}