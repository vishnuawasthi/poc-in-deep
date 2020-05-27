/*package com.app.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IndentificationRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:startIdentification").routeId("startIdentification")

				.process(exchange ->{
					
					System.out.println("body -> "+exchange.getIn().getBody());
					
					System.out.println("Start Process -> Called");
					
				})
		
		.end();

	}

}
*/