package com.app.routes;

import java.util.Random;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.mappers.SqlQueriesMapper;
import com.app.utils.DynamicRouteDeciderBean;

@Component
public class MyBatisExampleRouteBuilder extends RouteBuilder {

	@Autowired
	private SqlQueriesMapper sqlQueriesMapper;

	@Override
	public void configure() throws Exception {
		
		
		onException(Exception.class)
		
		.handled(false)
		.process(exchange ->{
			
			System.out.println("Exception ... ");
		})

		.end();
		
		
		
		from("direct:startQueryExample1")
				// .setHeader("").constant("")
				.to("mybatisComponent:selectUsers?statementType=SelectList").process(exchange -> {

					System.out.println("body -> " + exchange.getIn().getBody());

				}).end();

		from("direct:insertUsers").process(exchange -> {
			com.app.dto.Users users = new com.app.dto.Users();
			users.setId(new Random().longs(4).findAny().orElse(0));
			users.setPassword("Password");
			users.setUsername("Admin");
			exchange.getIn().setBody(users);

			// sqlQueriesMapper.insertUsers(users);

		}).to("mybatisComponent:insertUsers?statementType=Insert").end();

		// ##################### Routing Slip Example ####################

		from("direct:routingSlipExample").process(exchange -> {
			String routes = "direct:slipRouteTwo,direct:slipRouteThree,direct:slipRouteOne";
			exchange.getIn().setHeader("routingSlipHeader", routes);
		}).routingSlip(header("routingSlipHeader")).end();

		from("direct:slipRouteOne").process(exchange -> {
			System.out.println("direct:slipRouteOne   -> : " + exchange.getIn().getBody());
		}).end();

		from("direct:slipRouteThree").process(exchange -> {
			System.out.println("direct:slipRouteThree   -> :  " + exchange.getIn().getBody());
		}).end();

		from("direct:slipRouteTwo").process(exchange -> {
			System.out.println("direct:slipRouteTwo   -> :  " + exchange.getIn().getBody());
		}).end();

		
		//############################### Dynamic Routing Example ####################

		from("direct:startDynamicRouting")
			.dynamicRouter(bean(DynamicRouteDeciderBean.class,"routetoInvoke"))
			.process(exchange ->{
				System.out.println("Completed route process !");
			})
		.end();

		from("direct:dynamicRouteDesitinationOne").process(exchange -> {
			System.out.println("direct:dynamicRouteDesitinationOne   :  " + exchange.getIn().getHeader("processName"));
			exchange.getIn().setHeader("processName", "StepTwo");
		})
		.end();
		
		from("direct:dynamicRouteDesitinationStepTwo").process(exchange -> {
			System.out.println("direct:dynamicRouteDesitinationStepTwo   :  " +exchange.getIn().getHeader("processName"));
			exchange.getIn().setHeader("processName", "StepFinal");
		})
		.end();
		

		from("direct:dynamicRouteDesitinationStepFinal").process(exchange -> {
			System.out.println("direct:dynamicRouteDesitinationStepFinal   :  " + exchange.getIn().getHeader("processName"));
			exchange.getIn().setHeader("processName", "Over");
		})
		.end();

		
		
		
		//############################### Load balancer Routing Example ####################
		
		from("direct:startLoadBalancerEipExample")
		
		.split().header("itemList")
			//.loadBalance().roundRobin()  			// Picks channels based on round robin algorithm.
			//.loadBalance().random() 				// Pick channels randomly
		//.loadBalance().sticky(header("routeName"))  // all the message will go to same channel 
	//	.loadBalance().failover()					// If any thing fails in route one it will try to deliver same in route two.
			
		
		.loadBalance().failover(2,true,true)
				.to("direct:serverOne")
				.to("direct:serverTwo")
				.to("direct:serverThree")
			.end()
		.end()
			.process(exchange ->{
				System.out.println("Load balancing example compted ! ");
			})
		.end();

		
		from("direct:serverOne").process(exchange -> {
			System.out.println("Server One -> " +exchange.getIn().getBody());
			throw new Exception("Exception in route one");
			
		}).end();

		from("direct:serverTwo").process(exchange -> {
			System.out.println("Server Two -> "+exchange.getIn().getBody());
			throw new Exception("Exception in route one");
		}).end();

		from("direct:serverThree").process(exchange -> {
			System.out.println("Server Three -> "+exchange.getIn().getBody());
		}).end();
		
	}

}
