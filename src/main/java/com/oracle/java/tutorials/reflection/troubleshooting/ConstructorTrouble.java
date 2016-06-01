package com.oracle.java.tutorials.reflection.troubleshooting;

public class ConstructorTrouble {
	private ConstructorTrouble(int i) {
	}

	public static void main(String... args) {
		try {
			Class<?> c = Class.forName("ConstructorTrouble");
			@SuppressWarnings("unused")
			Object o = c.newInstance(); // InstantiationException

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (InstantiationException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		}
	}
}
