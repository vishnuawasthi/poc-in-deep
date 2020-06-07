package com.app.stream.examples;

import java.util.ArrayList;
import java.util.List;

import com.app.interfaces.LamdaExampleWithMultipleArguments;
import com.app.interfaces.LamdaExampleWithSingleArgument;
import com.app.interfaces.LamdaWithoutReturnExample;

public class Demp {

	public static void lamdaExamples() {

		LamdaExampleWithSingleArgument singleArgumentMethod = (name) -> {
			String greeting = "Welcome Member , " + name;
			return greeting;
		};
		System.out.println(singleArgumentMethod.greet("Ravi"));
	}

	
	public static int lamdaWithMultiArguments(int arg1, int arg2) {
	
		LamdaExampleWithMultipleArguments arguments = (int n1, int n2) -> {
			//int sum = n1 + n2;
			//return sum;
			
			if(n1> n2) {
				return n1;
			}
			return n2;
		};
		return arguments.getLargerNumber(arg1, arg2);
	}
	
	public static void lamdaWithoutReturnStatement() {
		LamdaWithoutReturnExample obj =  (n1,  n2)->{
			return (n1+n2);
		};
		int sum = obj.sum(10, 20);
		System.out.println("sum : "+sum);
	}
	
	
	public static void lamdaListExample() {
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("B");
		list.add("B");
		list.add("B");
		
		List<String> disQualified = new ArrayList<String>();
		
		list.removeIf(item->{
			boolean flag = "B".equalsIgnoreCase(item);
			if(flag) {
				disQualified.add(item);
			}
			
			return flag;
		});
		
		System.out.println(list);
		System.out.println(disQualified);
		
	}
	
	
	
	
	public static  void methodReferernceExample() {
		
		
		
		
		
		
	}
	
	
	public static void main(String... strings) {
		//lamdaExamples();
		
		//2. 
		//System.out.println("Greater Number : "+lamdaWithMultiArguments(9,2));
		
		//3. 
		//lamdaWithoutReturnStatement();
		
		//4.
		lamdaListExample();
		
	}

	
	
	
}
