package com.app.io.file;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class FileInputOutputDemo {

	public static void encodeDecodeExample() throws UnsupportedEncodingException {
		String src = "Hello Worlds";
		//byte[] encodedData = Base64.getEncoder().encode(src.getBytes());
		String encodedData = Base64.getEncoder().encodeToString(src.getBytes());
		System.out.println("encodedData  : "+encodedData);
		
		byte[] decodedData= Base64.getDecoder().decode(encodedData);
		
		System.out.println("decodedData  : "+new String(decodedData,"utf-8"));
	}

	public static void readFile() {

		File file = new File("C:\\opt\\input\\file1.txt");

		System.out.println(file.getAbsolutePath());
		System.out.println(file.getTotalSpace());

	}

	public static void main(String... strings) throws UnsupportedEncodingException {

		// 1.
		//readFile();
		// 2.
		encodeDecodeExample();
	}

}
