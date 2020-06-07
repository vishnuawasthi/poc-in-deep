package com.app.java8.howtodoinjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateExamples {
	
	
	
	

	public static void getAge() {
//04/28/1989
		String dateOfBirthString = "1989-04-28";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date dateOfBirth = null;
		try {
			dateOfBirth = simpleDateFormat.parse(dateOfBirthString);
			
			
			int day = dateOfBirth.getDate();
			
			int month = dateOfBirth.getMonth();
			
			int year = dateOfBirth.getYear();
			
			System.out.println("  day   : "+day);
			System.out.println("  month : "+(month+1));
			System.out.println("  year  : "+year);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("dateOfBirth : "+dateOfBirth);
		
		
		// Calendar calendar = GregorianCalendar.
		// Calendar calendar = new GregorianCalendar();
		// calendar.set(GregorianCalendar.YEAR, 1989);

	}

	public static void dateExample1() {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.minusYears(31));
	}

	public static void main(String[] args) {
		//dateExample1();
		
		 getAge() ;
	}

}
