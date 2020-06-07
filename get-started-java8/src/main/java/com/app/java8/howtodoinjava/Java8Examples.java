package com.app.java8.howtodoinjava;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.app.dto.Employee;
import com.app.interfaces.BinaryOperatioonExample;

public class Java8Examples {

	public static void consumerExample() {
		// List consumer example
		Consumer<String> cosumer = new Consumer<String>() {
			@Override
			public void accept(String t) {

				System.out.println("T   : " + t);
			}
		};

		List<String> string = Arrays.asList("A", "B");
		string.stream().forEach(cosumer);

		// BiConsumer

		Map<String, String> map = new HashMap<String, String>();
		map.put("Key1", "Value1");
		map.put("Key2", "Value2");
		map.put("Key3", "Value3");

		BiConsumer<String, String> biConsumer = new BiConsumer<String, String>() {
			@Override
			public void accept(String key, String value) {
				System.out.println(key + "    : " + value);
			}

		};

		// map.forEach(biConsumer);
		map.forEach((key, value) -> {
			System.out.println(key + " :  " + value);
		});
	}

	public static void lamdaExample() {
		BinaryOperatioonExample obj = (n1, n2) -> n1 + n2;
		int n3 = obj.add(10, 20);
		System.out.println(n3);

	}

	public static void limitExample() {

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

		numbers.stream().limit(3).forEach(System.out::println);

	}
	

	
	public static void predicateExample() {
		
		
		Calendar calendar = GregorianCalendar.getInstance();
		
		Employee emp1 = new Employee("Vishnu",calendar.getTime(),"MALE");
		Employee emp2 = new Employee("Ravi",calendar.getTime(),"MALE");
		Employee emp3 = new Employee("Mily",calendar.getTime(),"FEMALE");
		
		
		List<Employee> employees = Arrays.asList(emp1,emp2,emp3);
		
		List<Employee> males =	employees.stream().filter((employee)->{
			
			return "MALE".equalsIgnoreCase(employee.getGender());
		}).collect(Collectors.toList());
		
		System.out.println("males  : "+males);
	}

	public static void main(String[] args) {
		// 1.
		// lamdaExample();

		// 2.
		// consumerExample();

		// 3.
		// limitExample();
		
		//4
		predicateExample();
		
	}

}
