package com.tirmizee.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:db.properties" })
public class RepositoryConfig {
	
	public static final String MSSQL_DATASOURCE = "MSSQL_DATASOURCE";
	
	public static final String MSSQL_TRANSACTION = "MSSQL_TRANSACTION";
	
	@Autowired
	private Environment env;
	
	@Bean(MSSQL_DATASOURCE)
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean(MSSQL_TRANSACTION)
	public PlatformTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}

}
