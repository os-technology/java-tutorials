package com.eccl.product.liujian.tutorials.threads.demo.test;

public class CountManager implements Runnable {

	// in this test case, we just test to use the stop demo
	public static void main(String[] args) {
		System.out.println("program begin at " + System.nanoTime());
		Thread t = new Thread(new CountManager());
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		try {
			Thread.sleep(1000 * 20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("program stop now at" + System.nanoTime());
	}

	// Thread stop 异常终止所消耗的时间非常大
	@Override
	public void run() {
		long begin = 0L;

		long endSignal = ((long) Integer.MAX_VALUE) * 15L;
		try {
			begin = System.nanoTime();
			for (long i = 0L; i < endSignal; i++)
				;
		} finally {
			long end = System.nanoTime();
			System.out.println("final count:" + endSignal + ", elapse:" + (end - begin));
			System.out.println("thread begin at " + begin + " ,end at " + System.nanoTime());
		}
	}
}
