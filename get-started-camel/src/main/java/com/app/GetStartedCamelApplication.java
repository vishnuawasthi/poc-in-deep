package com.app;


//  https://www.javainuse.com/camel/camel-dynamic-router-example

  
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan(basePackages="com.app.mappers")
@SpringBootApplication
public class GetStartedCamelApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GetStartedCamelApplication.class, args);
	}

}
