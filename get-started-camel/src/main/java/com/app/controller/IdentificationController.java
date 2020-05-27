package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentificationController {

	@Autowired
	private CamelContext camelContext;

	@GetMapping(value = "/v1/indentification")
	public Object startIndentificationProcess() {

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		String requestBody = "This body is from controller";

		final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).withBody(requestBody).build();

		//producerTemplate.send("direct:startIdentification", requestExchange);
		
		//producerTemplate.send("direct:startFileProcessing",requestExchange);
		
	//	producerTemplate.send("seda:processFileRecords",requestExchange);
		
		///producerTemplate.send("direct:startQueryExample1",requestExchange);
		
		//producerTemplate.send("direct:insertUsers",requestExchange);
		//direct:insertUsers
		
		//direct:routingSlipExample
		requestExchange.getIn().setBody("This is body");
		//producerTemplate.send("direct:routingSlipExample",requestExchange);
		
		//producerTemplate.send("direct:startDynamicRouting", requestExchange);
		
		List<String> itemList = new ArrayList<String>();
		itemList.add("1");
		//itemList.add("2");
		/*itemList.add("3");
		itemList.add("4");
		itemList.add("5");
		itemList.add("6");
		itemList.add("7");*/
		
		requestExchange.getIn().setHeader("routeName", "direct:serverOne");
		requestExchange.getIn().setHeader("itemList", itemList);
		
		producerTemplate.send("direct:startLoadBalancerEipExample",requestExchange);
		
		return new ResponseEntity(HttpStatus.OK);
	}

}
