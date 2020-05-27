package com.app.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.datatypes.OrderContainer;

@Service
public class KafkaConsumerService {
	
/*	@KafkaListener(topics = "orders-topic", groupId = "ORDERS_POC")
	public void consumeOrders(String orders) {
		System.out.println("orders ->   " + orders);
	}*/
	
	@KafkaListener(topics = "orders-topic", groupId = "ORDERS_POC")
	public void consumeOrders(OrderContainer orders) {
		System.out.println("orders ->   " + orders);
	}
}
