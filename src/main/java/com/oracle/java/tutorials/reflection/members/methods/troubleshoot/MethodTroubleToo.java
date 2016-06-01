package com.oracle.java.tutorials.reflection.members.methods.troubleshoot;

import java.lang.reflect.Method;

public class MethodTroubleToo {
	public void ping() {
		System.out.format("PONG!%n");
	}

	public static void main(String... args) {
		try {
			MethodTroubleToo mtt = new MethodTroubleToo();
			Method m = MethodTroubleToo.class.getMethod("ping");

			switch (Integer.parseInt(args[0])) {
			case 0:
				m.invoke(mtt); // works
				break;
			case 1:
				m.invoke(mtt, (Object[]) null); // works (expect compiler
												// warning)
				break;
			case 2:
				Object arg2 = null;
				m.invoke(mtt, arg2); // IllegalArgumentException
				break;
			case 3:
				m.invoke(mtt, new Object[0]); // works
				break;
			case 4:
				Object arg4 = new Object[0];
				m.invoke(mtt, arg4); // IllegalArgumentException
				break;
			default:
				System.out.format("Test not found%n");
			}

			// production code should handle these exceptions more gracefully
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}