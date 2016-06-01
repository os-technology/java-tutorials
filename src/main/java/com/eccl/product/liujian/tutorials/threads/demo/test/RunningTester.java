/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * 
 */
public class RunningTester {

	int j = 10;

	/**
	 * @param args
	 */
	synchronized public void execute(Thread th) {
		String threadName = th.getName();
		if (j > 10) {
			System.out.println(threadName + " j>10");
			j = 10;
		} else if (j <= 10 && j > 5) {
			System.out.println(threadName + " j between 5 and 10-- j" + j);
			j--;
		} else {
			System.out.println(threadName + " j:" + j--);
		}
	}
}
