/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * @version 1.0
 */
public class TestOverrideRunThreadDemo extends Thread {

	int i = 0;

	public void run() {
		i++;
		System.out.println("this is the original run.:" + i);

	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		TestOverrideRunThreadDemo demo = new TestOverrideRunThreadDemo() {
			public void run() {
				System.out.println("this is the dynamic run method." + i);
			}
		};

		// demo.run();
		demo.start();
		int i = 0;
		while (i < 5) {
			if (demo.isAlive()) {
				Thread.sleep(1000);
			} else {
				demo.start();
			}
		}
	}
}
