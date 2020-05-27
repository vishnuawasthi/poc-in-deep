package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.datatypes.OrderContainer;
import com.app.kafka.services.KafkaProducerService;

@RestController
public class OrderController {

	//@Autowired
	//private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaProducerService kakfaProducerService;

	private static final String MSG_TOPIC = "orders-topic";

	@PostMapping(value = "/messages")
	public Object receiveMessage(@RequestBody OrderContainer payload) {

		System.out.println("receiveMessage  -> " + payload);

		//kafkaTemplate.send(MSG_TOPIC, data);

		kakfaProducerService.sendOrder(payload);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
