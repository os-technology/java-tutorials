/**
 * 
 */
package cn.aposoft.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UseCase 1: 说明volatile在复合操作时,不能保持数据的正确性.
 * 
 * @author LiuJian
 *
 */
public class VolatileTest implements Runnable {
	private static final int THREAD_NUM = 4;
	private static final long TIME_OUT = 5000L;
	private volatile long longValue = 0L;
	private volatile int intValue = 0;
	private volatile long mockLongValue = 0x100000000L;
	private volatile int mockIntValue = 0;
	private AtomicInteger seed = new AtomicInteger(0);
	private AtomicInteger currentThreads = new AtomicInteger(0);

	public long getLongValue() {
		return longValue;
	}

	public int getIntValue() {
		return intValue;
	}

	/**
	 * @return the mockLongValue
	 */
	public long getMockLongValue() {
		return mockLongValue;
	}

	/**
	 * @param mockLongValue
	 *            the mockLongValue to set
	 */
	public void setMockLongValue(long mockLongValue) {
		this.mockLongValue = mockLongValue;
	}

	/**
	 * @return the mockIntValue
	 */
	public int getMockIntValue() {
		return mockIntValue;
	}

	/**
	 * @param mockIntValue
	 *            the mockIntValue to set
	 */
	public void setMockIntValue(int mockIntValue) {
		this.mockIntValue = mockIntValue;
	}

	/**
	 * 被唤醒后,确认是否全部线程都已经结束
	 */
	public void await() {
		try {
			while (currentThreads.get() > 0) {
				synchronized (this) {
					this.wait(); // 等待
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 唤醒全部线程
	 */
	public void signalAll() {
		synchronized (this) {
			this.notifyAll();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			long begin = System.nanoTime();
			VolatileTest test = new VolatileTest();
			BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
					THREAD_NUM);
			// BlockingQueue<Runnable> queue = new
			// LinkedBlockingQueue<Runnable>(THREAD_NUM);
			service = new ThreadPoolExecutor(THREAD_NUM, THREAD_NUM, TIME_OUT,
					TimeUnit.SECONDS, queue);
			long middle = System.nanoTime();
			for (int i = 0; i < 4; i++) {
				service.execute(test);
			}

			test.await();
			long end = System.nanoTime();
			System.out.println(test.getLongValue() + ","
					+ (test.getMockLongValue() - 0x100000000L) + ","
					+ test.getIntValue() + "," + test.getMockIntValue()
					+ ", calculate elapse:" + (end - middle)
					+ " nano seconds, initialized elapse:" + (middle - begin)
					+ " nano seconds.");
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}

	@Override
	public void run() {
		int threadNum = currentThreads.incrementAndGet();
		int operator;
		if (threadNum % 2 == 0) {
			operator = 1;
		} else {
			operator = -1;
		}
		int increment = seed.getAndIncrement();
		System.out.println(increment);
		for (long i = 0; i < 1000 * 1000; i++) {
			longValue += operator;
			mockLongValue += operator;
			intValue += operator;
			mockIntValue += operator;
		}
		currentThreads.decrementAndGet();

		synchronized (this) {
			this.notifyAll();
		}
	}
}
