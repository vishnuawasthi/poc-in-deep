package com.app.stream.examples;

import com.app.interfaces.LamdaExampleWithSingleArgument;

public class Demp {

	
	public static void lamdaExamples() {
		
		
		LamdaExampleWithSingleArgument singleArgumentMethod = 
				
				(name)->{
					String greeting ="Welcome Member , "+name;
					return greeting;
					
				};
				
				/*(name->{
			
			return "Hello My Dear "+name;
		});*/
		
				System.out.println(singleArgumentMethod.greet("Ravi"));;
	}
	public static void main(String... strings) {
		lamdaExamples();
	}

}
