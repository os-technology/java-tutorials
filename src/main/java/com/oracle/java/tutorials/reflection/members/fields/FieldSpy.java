package com.oracle.java.tutorials.reflection.members.fields;

import java.lang.reflect.Field;
import java.util.List;
import java.lang.Class;

public class FieldSpy<T> {
	public boolean[][] b = { { false, false }, { true, true } };
	public String name = "Alice";
	public List<Integer> list;
	public T val;

	public static void main(String... args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Field f = c.getDeclaredField(args[1]);
			f.setAccessible(true);
			System.out.format("Type: %s%n", f.getType());
			System.out.format("GenericType: %s%n", f.getGenericType());

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (NoSuchFieldException x) {
			x.printStackTrace();
		}
	}
}