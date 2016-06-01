/*
 *	本样例着重演示: Constructor 类利用反射创建 类实例的方法.
 * 
 */
package com.oracle.java.tutorials.reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Cls {
	private Cls() {
		this("default");
	}

	private Cls(String s) {
		System.out.println("s is :" + s);
	}
}

public class ClassTrouble {
	public static void main(String... args) throws NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {
		try {
			@SuppressWarnings("unused")
			Class<?> c = Class
					.forName("com.oracle.java.tutorials.reflection.membercalling.Cls");

			Class<?> clazz = Cls.class;

			Constructor<?>[] cons = Cls.class.getDeclaredConstructors();
			for (Constructor<?> con : cons) {
				Class<?>[] paramsTypes = con.getParameterTypes();
				if (paramsTypes.length == 1 && paramsTypes[0] == String.class) {
					con.setAccessible(true);
					@SuppressWarnings("unused")
					Cls cls = (Cls) con.newInstance("sName"); // InstantiationException
				}
			}

			// 想要访问内部实例,需要使用 反射 AccessibleObject的子类,Constructor<?>
			// getConstructor(Class<?>... parameterTypes) can not suppress
			// access control checks
			// getDecalredConstructor(Class<?>... parameterTypes) is just OK.
			Constructor<?> con1 = clazz.getDeclaredConstructor();
			con1.setAccessible(true);
			@SuppressWarnings("unused")
			Cls cls = (Cls) con1.newInstance(); // InstantiationException
			// production code should handle these exceptions more gracefully
		} catch (InstantiationException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}
}