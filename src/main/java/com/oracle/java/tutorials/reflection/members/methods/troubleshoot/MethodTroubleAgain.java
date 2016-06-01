package com.oracle.java.tutorials.reflection.members.methods.troubleshoot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AnotherClass {
	@SuppressWarnings("unused")
	private void m() {
	}
}

public class MethodTroubleAgain {
	public static void main(String... args) {
		AnotherClass ac = new AnotherClass();
		try {
			Class<?> c = ac.getClass();
			Method m = c.getDeclaredMethod("m");
			// m.setAccessible(true); // solution
			@SuppressWarnings("unused")
			Object o = m.invoke(ac); // IllegalAccessException

			// production code should handle these exceptions more gracefully
		} catch (NoSuchMethodException x) {
			x.printStackTrace();
		} catch (InvocationTargetException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		}
	}
}