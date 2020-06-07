package com.app.java8.howtodoinjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.app.dto.Student;

public class CamparatorExample {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();
		
		Comparator<Student> comparator = Comparator.comparing(Student::getMarks).reversed().thenComparing(Student::getFirstname);
		

		
		
		
		Student s1 = new Student("Anay", "Awasthi", 50);
		Student s3 = new Student("Bat", "Cat", 45);
		Student s4 = new Student("Dog", "Lee", 30);
		Student s5 = new Student("Elephant", "Bit", 38);
		Student s2 = new Student("Vinay", "Awasthi", 50);
		Student s6 = new Student("Vinay", "Bwasthi", 50);
		students.add(s1);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s2);
		students.add(s6);

		students.stream().forEach(student -> {
			System.out.println(student.getFirstname() + "  " + student.getLastname() + "  " + student.getMarks());
		});
		
		System.out.println("--------------------------------------------");
		//students.sort(comparator);
		
		students.sort(Comparator.comparing(Student::getMarks).reversed().thenComparing(Student::getFirstname).thenComparing(Student::getLastname));
		
		students.stream().forEach(student -> {
			System.out.println(student.getFirstname() + "  " + student.getLastname() + "  " + student.getMarks());
		});
	}

}
