/**
 * 
 */
package cn.aposoft.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jann Liu
 *
 */

// An example of using Lock.
public class LockTest {

	public static void main(String[] args) {
		new LockTest().init();

	}

	private void init() {
		final Outputer outputer = new Outputer();
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true && !Thread.currentThread().isInterrupted()) {
					Thread.yield();
					outputer.output("aaaaaaaaaaa");
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true && !Thread.currentThread().isInterrupted()) {
					Thread.yield();
					outputer.output("bbbbbbbbbbb");
				}
			}
		});
		t1.start();
		t2.start();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				t1.interrupt();
				t2.interrupt();
			}
		});
	}

	static class Outputer {
		private Lock lock = new ReentrantLock();

		public void output(String name) {
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();

			} finally {
				lock.unlock();
			}

		}

	}

}