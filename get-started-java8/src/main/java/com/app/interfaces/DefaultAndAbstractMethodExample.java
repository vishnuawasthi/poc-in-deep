package com.app.interfaces;

public interface DefaultAndAbstractMethodExample {

	static void printMe(String msg) {
		System.out.println(msg);
	}

	default void showMe(String msg) {
		System.out.println("ShowMe  -> " + msg);
	}

	public static void main(String... args) {
		DefaultAndAbstractMethodExample obj = new DefaultAndAbstractMethodExample() {

		};

		obj.showMe("This is ");
	}
}
