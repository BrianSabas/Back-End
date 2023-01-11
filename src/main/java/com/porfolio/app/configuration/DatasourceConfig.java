package com.porfolio.app.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
	
	@Value("${spring.datasource.url}")
	private String strURL;
	
	@Value("${spring.datasource.username}")
	private String strUserName;
	
	@Value("${spring.datasource.password}")
	private String strPassword;
	
	@Value("${spring.datasource.driver-class-name}")
	private String strDriver;
	/*
	@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName(strDriver)
                .url(strURL)
                .username(strUserName)
                .password(strPassword)
                .build();
    }
	*/
}
