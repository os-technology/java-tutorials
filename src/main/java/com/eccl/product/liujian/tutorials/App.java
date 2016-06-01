package com.eccl.product.liujian.tutorials;

import java.util.Calendar;

/**
 * Hello world!
 * 
 */
public class App {

	static public void main(String[] a) {

		// boolean bool = null;
		char ch = 12700;
		byte by = 12;
		System.out.println(by + ch);
		int i = 10 << 3;
		int j = ~i;
		System.out.printf("%s %s%n", Integer.toBinaryString(i),
				Integer.toBinaryString(j));

		System.out.println("Hello World!");
		String one = "Hello World!";
		String other = "Hello World!";
		// String nvl = null;
		// String compareTo(String other) does not check the null argument
		// System.out.println(one.compareTo(nvl));
		System.out.println(one.equals(other));

		Calendar c = Calendar.getInstance();
		c.set(2013, 8, 28);
		System.out.println(c.getTime());
		c.add(Calendar.DATE, 100);
		System.out.println(c.getTime());
	}
}
