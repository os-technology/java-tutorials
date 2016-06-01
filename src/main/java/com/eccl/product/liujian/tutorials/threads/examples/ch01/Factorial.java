/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.examples.ch01;

/**
 * @author LiuJian
 * 
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String... args) {

		int n = 10;// Integer.parseInt(10);

		System.out.print(n + "! is ");

		int fact = 1;

		while (n > 1)

			fact *= n--;

		System.out.println(fact);

	}

}
