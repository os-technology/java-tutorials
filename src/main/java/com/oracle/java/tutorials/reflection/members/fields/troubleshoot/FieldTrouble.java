package com.oracle.java.tutorials.reflection.members.fields.troubleshoot;

import java.lang.reflect.Field;

public class FieldTrouble {
	public Integer val;

	public static void main(String... args) {
		FieldTrouble ft = new FieldTrouble();
		try {
			Class<?> c = ft.getClass();
			Field f = c.getDeclaredField("val");
			// f.setInt(ft, 42); // IllegalArgumentException
			f.set(ft, 42);
			// production code should handle these exceptions more gracefully
		} catch (NoSuchFieldException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		}
	}
}