/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test.thread;

/**
 * @author LiuJian
 * 
 */
public class ThreadTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final NumberOperator op = new NumberOperator(100, 5);

		Thread increase1 = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean done = false;
				while (!done) {
					done = op.increase();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()
						+ ":out of run");
			}
		});

		Thread increase2 = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean done = false;
				while (!done) {
					done = op.increase();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()
						+ ":out of run");
			}
		});
		Thread decrease1 = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean done = false;
				while (!done) {
					done = op.decrease();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()
						+ ":out of run");
			}
		});

		Thread decrease2 = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean done = false;
				while (!done) {
					done = op.decrease();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()
						+ ":out of run");
			}
		});

		increase1.start();
		increase2.start();
		decrease1.start();
		decrease2.start();
	}
}
