package com.springboot.spring.config;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DB {
    private String driverClassName;
	private String url;
	private String userName;
	private String password;

    @Profile("devel")
	@Bean
	public String devDatabaseConnection() {
		
		System.out.println("devel");
		System.out.println(driverClassName);
		System.out.println(url);
		return "H2 Connection";
		
	}
	
    @Profile("test")
	@Bean
	public String testDatabaseConnection() {
		
		System.out.println("test");
		System.out.println(driverClassName);
		System.out.println(url);
		return "Test Connection";
		
	}
    
}
