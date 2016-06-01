/**
 * 
 */
package cn.aposoft.util.concurrent.semaphore;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jann Liu
 *
 */
public class PoolUser {
	static CountDownLatch prepare = new CountDownLatch(1);
	static CountDownLatch start = new CountDownLatch(1);
	static Pool pool = new Pool();

	public static void main(String[] args) {
		PoolConsumer consumer = new PoolConsumer();
		PoolProvider provider = new PoolProvider();
		ExecutorService service = Executors.newFixedThreadPool(2);

		try {
			service.execute(provider);
			service.execute(consumer);

		} finally {
			service.shutdown();
		}
	}

	static class PoolConsumer implements Runnable {

		@Override
		public void run() {
			// 启动同步
			try {
				System.out.println("Consumer call Provider.");
				prepare.countDown();
				System.out.println("Consumer waits Provider.");
				start.await();
				System.out.println("Consumer is running.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < 1; i++) {
				try {
					Object o = pool.getItem();
					System.out.println("at:" + i + ",get:" + o);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class PoolProvider implements Runnable {
		Random r = new Random();

		@Override
		public void run() {
			try {
				System.out.println("Provider wait prepare.");
				prepare.await();
				System.out.println("Provider wakeups consumer.");
				start.countDown();
				System.out.println("Provider is running.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < 1; i++) {
				// Semaphore method
				int value = r.nextInt(100);
				System.out.println("at:" + i + ",put:" + value);
				pool.putItem(value);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
