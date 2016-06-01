package com.oracle.java.tutorials.reflection.members.methods.troubleshoot;

import java.lang.reflect.Method;

public class MethodTrouble<T> {
	public void lookup(T t) {
	}

	public void find(Integer i) {
	}

	public static void main(String... args) {
		try {
			String mName = args[0];
			Class<?> cArg = Class.forName(args[1]);
			Class<?> c = (new MethodTrouble<Integer>()).getClass();
			Method m = c.getMethod(mName, cArg);
			System.out.format("Found:%n  %s%n", m.toGenericString());

			// production code should handle these exceptions more gracefully
		} catch (NoSuchMethodException x) {
			x.printStackTrace();
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}
}