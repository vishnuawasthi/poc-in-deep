package com.app.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.app.datatypes.OrderContainer;

@Service
public class KafkaProducerService {

	@Autowired
	@Qualifier("orderKafkaTemplate")
	private KafkaTemplate<String, OrderContainer> orderKafkaTemplate;

	public void sendOrder(OrderContainer payload) {
		System.out.println("orderContainer -> " + payload);

		Message<OrderContainer> message = MessageBuilder
										    .withPayload(payload)
											.setHeader(KafkaHeaders.TOPIC, "orders-topic")
											.build();
		orderKafkaTemplate.send(message);

	}
}
