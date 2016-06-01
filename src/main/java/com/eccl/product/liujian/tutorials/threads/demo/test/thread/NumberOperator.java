/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test.thread;

/**
 * @author LiuJian
 * 
 */
public class NumberOperator {

	// Illegal modifier for the constructor in type NumberOperator; only public,
	// protected & private are permitted
	// synchronized
	public NumberOperator(int maxCount, int j) {
		this.maxCount = maxCount;
		this.j = j;
	}

	private int maxCount;
	private int count = 0;
	private int j;

	public synchronized boolean increase() {
		if (count < maxCount) {
			count++;
			j++;
			System.out.println(Thread.currentThread().getName()
					+ " -- increase:count=" + count + ",j=" + j);
			return false;
		} else {
			return true;
		}

	}

	public synchronized boolean decrease() {
		if (count < maxCount) {
			count++;
			j--;
			System.out.println(Thread.currentThread().getName()
					+ " -- decrease:count=" + count + ",j=" + j);
			return false;
		} else {
			return true;
		}
	}
}
