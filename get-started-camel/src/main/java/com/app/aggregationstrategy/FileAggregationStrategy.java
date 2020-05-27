package com.app.aggregationstrategy;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class FileAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

		int totalRecordsSize = 0;

		if (oldExchange == null) {
			List<List<String>> data = (List<List<String>>) newExchange.getIn().getBody();
			totalRecordsSize = data.size();
			newExchange.setProperty("totalRecordsSize", totalRecordsSize);
			return newExchange;
			
		} else {
			
			totalRecordsSize = oldExchange.getProperty("totalRecordsSize", 0,Integer.class);
			List<List<String>> data = (List<List<String>>) newExchange.getIn().getBody();
			
			int totalSize = data.size();
			
			totalRecordsSize = totalRecordsSize+totalSize;
			
			oldExchange.setProperty("totalRecordsSize", totalRecordsSize);
			return oldExchange;
		}

	}

}
