package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.app.datatypes.OrderContainer;

@Configuration
@EnableKafka
public class KafkaConfig {

	@Bean("orderKafkaTemplate")
	@DependsOn("orderProducerFactory")
	public KafkaTemplate<String, OrderContainer> kafkaTemplate(ProducerFactory<String, OrderContainer> factory) {
		return new KafkaTemplate<>(factory);
	}

	@Bean("orderProducerFactory")
	public ProducerFactory<String, OrderContainer> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-3-23-87-67.us-east-2.compute.amazonaws.com:9092");
		config.put(ProducerConfig.ACKS_CONFIG, "all");
		config.put(ProducerConfig.RETRIES_CONFIG, 0);
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, 1000);
		config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory(config);
	}
	
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, OrderContainer> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderContainer> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(true);
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, OrderContainer> consumerFactory(){
		JsonDeserializer<OrderContainer> deserializer = new JsonDeserializer<>(OrderContainer.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);
	    Map<String, Object> config = new HashMap<>();
	    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-3-23-87-67.us-east-2.compute.amazonaws.com:9092");
	   // config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_one");
	    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
	    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
	    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
	}
	
}
