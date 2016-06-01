package com.oracle.java.tutorials.reflection.troubleshooting;

import java.lang.reflect.Method;

public class ClassWarning {
	public void m() {
		try {
			Class<ClassWarning> c = ClassWarning.class;

			Method[] ms = c.getMethods();
			for (Method me : ms) {
				System.out.println(me.toGenericString());
			}
			Method m = c.getMethod("m"); // warning
			System.out.println(m.toGenericString());
			// production code should handle this exception more gracefully
		} catch (NoSuchMethodException x) {
			x.printStackTrace();
		}
	}

	public static void main(String... args) {
		new ClassWarning().m();
	}
}
