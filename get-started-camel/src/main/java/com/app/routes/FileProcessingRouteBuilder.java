/*package com.app.routes;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.aggregationstrategy.AggregationStrategyExample1;
import com.app.aggregationstrategy.FileAggregationStrategy;

@Component
public class FileProcessingRouteBuilder extends RouteBuilder {

	@Autowired
	private FileAggregationStrategy fileAggregationStrategy;
	
	@Autowired
	private AggregationStrategyExample1 aggregationStrategyExample1;

	@Override
	public void configure() throws Exception {

		from("direct:startFileProcessing").process(exchange -> {
			System.out.println("Started file processing ...");
		}).end();

		//&fileName=RECORD_FILE_${date:now:yyyyMMdd}
		//move=.processed
		from("file://C:/opt/camelexamples?noop=true&delay=1000")
				 .split(body().tokenize("\n", 5, true),new FileAggregationStrategy()).streaming()
				 .unmarshal().csv()
				 .process(exchange -> {
					List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
					System.out.println("lines->  " + data);
				 })
			//	.aggregate(constant(true),fileAggregationStrategy)
			//	.completionTimeout(1000)
				.to("seda:processFileRecords")
		.end()
				.process(exchange->{
					System.out.println("totalRecordsSize -> "+exchange.getProperty("totalRecordsSize"));
				})
				.end();
		
		
		from("seda:processFileRecords").routeId("processFileRecords")
			.process(exchange ->{
				System.out.println("exchange data by seda call -> "+exchange.getIn().getBody());
			})
			.setHeader("myKeyHeader").constant("MY_KEY_HEADER_VALUE")
			.setProperty("MY_KEY_PROPERTY").constant("MY_KEY_PROPERTY_VALUE")
			.pollEnrich("file://C:/opt/camelexamples?fileName=21linesfile.txt")
			.split(body().tokenize("\n", 5, true)).streaming()
			.unmarshal().csv()
			
			.process(exchange -> {
				
				System.out.println("MY_KEY_PROPERTY   : "+exchange.getProperty("MY_KEY_PROPERTY"));
				System.out.println("myKeyHeader       : "+exchange.getIn().getHeader("myKeyHeader"));
				
				List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
				System.out.println("lines->  " + data);
			 })
			
			
		.end();
		
		// Split Example -1 
		
		
		
	}

}
*/