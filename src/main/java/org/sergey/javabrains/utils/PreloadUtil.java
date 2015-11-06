package org.sergey.javabrains.utils;

import java.util.Properties;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.sergey.javabrains.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:settings.properties")
public class PreloadUtil {
	
	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		
		System.out.println("TEST = " + env.getRequiredProperty("pg.url"));
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getRequiredProperty("pg.url"));
		ds.setDriverClassName(env.getRequiredProperty("pg.driver"));
		ds.setUsername(env.getRequiredProperty("pg.user"));
		ds.setPassword(env.getRequiredProperty("pg.password"));
		return ds;
	}

	@Bean
	Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		return props;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		sf.setHibernateProperties(hibernateProperties());
		sf.setAnnotatedPackages("org.sergey.javabrains.domain");
		sf.setAnnotatedClasses(Customer.class);

		return sf;
	}
	
	@Bean
	public SpringLiquibase springLiquibase() {
		SpringLiquibase springLiquibase = new SpringLiquibase();
		springLiquibase.setDataSource(dataSource());
		springLiquibase.setChangeLog(env
				.getRequiredProperty("liquibase.changelog"));
		return springLiquibase;
	}

}
