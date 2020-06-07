package com.app.java8.howtodoinjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesExample {

	public static void main(String[] args) throws IOException {

		Path filePath = Paths.get("D:\\opt\\wagepayment\\input", "CARD_ORDER_GOOD_FILE-2.txt");

		Files.lines(filePath).forEach(line -> {
			System.out.println(line);

			String rowData[] = line.split(",");

			System.out.println(Arrays.toString(rowData));

		});
	}
}