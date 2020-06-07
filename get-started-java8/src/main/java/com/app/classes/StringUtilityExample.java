package com.app.classes;

import java.util.Scanner;

import org.springframework.aop.aspectj.annotation.SingletonMetadataAwareAspectInstanceFactory;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import com.app.interfaces.LamdaExampleWithSingleArgument;

public class StringUtilityExample {

	public static String printMessage(String name) {
		// System.out.println("Hello ," + name);
		return "Hello , " + name;
	}

	public static void readingString() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Data :");
		int i = scan.nextInt();
		double d = scan.nextDouble();
		scan.nextLine();
		String s = null;

		s = scan.nextLine();

		System.out.println("i : " + i);
		System.out.println("d : " + d);
		System.out.println("s : " + s);

	}

	public static void main(String... strings) {

		Scanner scan = new Scanner(System.in);
		System.out.println("================================");

		for (int i = 0; i < 3; i++) {
			String s1 = scan.next();
			int x = scan.nextInt();
			// Complete this line

			int k = 0;
			StringBuilder builder = new StringBuilder(s1);
			int loopIndex = 15-s1.length(); 
			
			while (k < loopIndex) {
				builder.append(" ");
				k++;
			}

			String str = String.valueOf(x);
			
			while(str.length() < 3) {
				str = "0" + str;
			}

			builder.append(str);
			System.out.println(builder.toString());
		}
		System.out.println("================================");
	}

}
