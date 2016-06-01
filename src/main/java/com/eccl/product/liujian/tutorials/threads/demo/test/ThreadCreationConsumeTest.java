/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * 
 */
public class ThreadCreationConsumeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			Thread thread = new Thread();
			thread.start();
		}
		long end = System.currentTimeMillis();
		System.out.println("duration:" + (end - begin));
	}

}
