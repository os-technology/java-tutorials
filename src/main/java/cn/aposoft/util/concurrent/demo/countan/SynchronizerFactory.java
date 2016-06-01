/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuJian
 * @version 1.0
 */
public class SynchronizerFactory {
	/**
	 * make default singleton ,use holder technology
	 * 
	 * @return {@link SyncErrorHandler} by default
	 */
	public static SyncErrorHandler defaultSyncErrorHandler() {
		return DefaultSyncErrorHandler.instance;
	}

	public static Synchronizer newSynchronizer() {
		return newSynchronizer(1);
	}

	public static Synchronizer newSynchronizer(int count) {
		return newSynchronizer(count, defaultSyncErrorHandler());
	}

	public static Synchronizer newSynchronizer(int count, SyncErrorHandler handler) {
		return new DefaultSynchronizer(count, handler);
	}

	private static class DefaultSyncErrorHandler implements SyncErrorHandler {
		private final static SyncErrorHandler instance = new DefaultSyncErrorHandler();

		@Override
		public void onError(Throwable e) {
			System.err.println("Synchronizer meets some error");
		}
	}

	private static class DefaultSynchronizer implements Synchronizer {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();
		private SyncErrorHandler handler;
		private CountDownLatch latch;

		public DefaultSynchronizer(int count, SyncErrorHandler handler) {
			latch = new CountDownLatch(count);
			this.handler = handler;
		}

		@Override
		public void lock() {
			lock.lock();
		}

		@Override
		public void unlock() {
			lock.unlock();
		}

		@Override
		public void await() throws InterruptedException {
			try {
				lock();
				condition.await();
			} finally {
				unlock();
			}
		}

		@Override
		public void signal() {
			try {
				lock();
				condition.signal();
			} finally {
				unlock();
			}
		}

		@Override
		public void signalAll() {
			try {
				lock();
				condition.signalAll();
			} finally {
				unlock();
			}

		}

		@Override
		public void signalStarted() {
			latch.countDown();
		}

		@Override
		public void awaitStarted() throws InterruptedException {
			latch.await();
		}

		@Override
		public void error(Throwable e) {
			handler.onError(e);
		}

	}

}
