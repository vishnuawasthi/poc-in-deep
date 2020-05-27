package com.app.routes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataTransformationExampleRouteBuilder extends RouteBuilder {

	@Autowired
	private CsvDataFormat csvDataFormat;
	
	@Override
	public void configure() throws Exception {

		// from("direct:startDataTransformation")

		/*from("direct:startCsvFileMarshalExample")

				
				.process(exchange ->{
					List<Map<String, Object>>  list = new ArrayList();
					
					
					Map<String, Object> keyValuesMap = new LinkedHashMap<String, Object>();
					keyValuesMap.put("ID", "100");
					keyValuesMap.put("NAME", "Vishnu");
					keyValuesMap.put("Email", "Test@gmail.com");
					keyValuesMap.put("City", "HYD");
					keyValuesMap.put("Country", "IND");
					
					list.add(keyValuesMap);
					list.add(keyValuesMap);
					list.add(keyValuesMap);
					list.add(keyValuesMap);
					list.add(keyValuesMap);
					exchange.getIn().setBody(list);
					
					
				})
				.marshal(csvDataFormat)
				
				.to("file:C:\\opt\\camelexamples\\processed?fileName=outputFile.csv")
				
				.end();
		*/
		
		
		from("file:C:\\opt\\camelexamples?fileName=Inputfile.csv")
		
			.unmarshal(csvDataFormat)
			
			.process(exchange ->{
				//System.out.print(exchange.getIn().getBody());
				
			})
			
			.split(body())
			
			.process(exchange ->{
				//System.out.println( "lines -> "  +exchange.getIn().getBody());
			})
			.to("seda:processUsingSedaCall")
			.end()
			//.to("file:C:\\opt\\camelexamples\\processed?fileName=userInfo.csv")
			.process(exchange ->{
				System.out.println("Process completed successfully !");
			})
		.end();
		
		from("seda:processUsingSedaCall")
			.process(exchange ->{
				System.out.println( "Using Seda lines -> "  +exchange.getIn().getBody());
			})
		.end();

	}

}
