/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * 
 */
public class RunningTesterExecuteThread extends Thread {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// here tester must be final;
		final RunningTester tester = new RunningTester();
		Thread th = new RunningTesterExecuteThread() {
			public void run() {
				tester.execute(this);
			}
		};

		// Thread.sleep(1000);
		Thread th1 = new RunningTesterExecuteThread() {
			public void run() {
				tester.execute(this);
			}
		};
		th1.start();

		th.start();
	}
}
