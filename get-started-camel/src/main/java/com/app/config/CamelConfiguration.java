package com.app.config;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * Reference for MyBatis : http://mybatis.org/spring/mappers.html#register
 * 
 * @author Dell
 *
 */

@SpringBootConfiguration
public class CamelConfiguration {

	// @Autowired
	private CamelContext context;

	// @Autowired
	private List<RouteBuilder> routes;

	@Bean
	public CsvDataFormat dataFormat() {
		String[] headers = { "ID", "NAME", "Email", "City", "Country" };
		CsvDataFormat csvDataFormat = new CsvDataFormat();
		csvDataFormat.setDelimiter(",");
		csvDataFormat.setHeader(Arrays.asList(headers));
		csvDataFormat.setSkipHeaderRecord(true);
		return csvDataFormat;

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/POC_SCHEMA");
		dataSource.setUsername("POC_ADMIN");
		dataSource.setPassword("login@123");
		return dataSource;
	}

	@Bean("sqlSessionFactory")
	@DependsOn("dataSource")
	public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) {
		org.mybatis.spring.SqlSessionFactoryBean sqlSessionFactory = new org.mybatis.spring.SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		
		//sqlSessionFactory.setMapperLocations(new  ClassPathResource("com/ap/mappers/"));
		
		//ClassPathResource mapperLocations = new ClassPathResource("com/app/mappers/Employee.xml");
		
		//sqlSessionFactory.setMapperLocations(mapperLocations);
		
		return sqlSessionFactory;
	}

	@Bean("mybatisComponent")
	@DependsOn("sqlSessionFactory")
	public MyBatisComponent myBatisComponent(@Autowired SqlSessionFactory sqlSessionFactory) {
		MyBatisComponent myBatisComponent = new MyBatisComponent();
		myBatisComponent.setSqlSessionFactory(sqlSessionFactory);
		//myBatisComponent.setConfigurationUri("com.app.mappers");
		System.out.println("myBatisComponent->"+myBatisComponent.isStarted());
		return myBatisComponent;
	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
	    MapperScannerConfigurer configurer = new MapperScannerConfigurer();
	    configurer.setBasePackage("com.app.mappers");
	    configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	    return configurer;
	}
}
