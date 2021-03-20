package com.app.gethyphen.config;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	public static String url;
    public static String browser;
    public static String mode;
    public static String email;
    public static String otp;
	
	public static void setProperties(String environment) throws Exception{
		
		Properties p = new Properties();
        p.load((new FileInputStream(System.getProperty("user.dir") + "/configFiles/demo.properties")));
        System.out.println(p.toString());
        url = p.getProperty(environment+".URL");
        browser = p.getProperty(environment+".browser").toUpperCase();
        mode = p.getProperty(environment+".mode").toLowerCase();
        email = p.getProperty(environment+".email");
        otp = p.getProperty(environment+".otp");
	}

}
