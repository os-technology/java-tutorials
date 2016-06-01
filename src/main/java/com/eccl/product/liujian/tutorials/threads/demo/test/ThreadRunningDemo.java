/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * 
 */
public class ThreadRunningDemo extends Thread {

	@Override
	public void run() {
		// System.out.println("call run directly.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			new ThreadRunningDemo().run();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			new ThreadRunningDemo().start();//
		long end = System.currentTimeMillis();
		System.out.println((end - begin) + ":" + (begin - init));
	}
}
