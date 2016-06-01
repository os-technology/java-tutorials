/**
 * 
 */
package cn.aposoft.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuJian
 *
 */
public class VolatileLongTest {
	// private final Random r = new Random();
	private final AtomicInteger readThreadNum = new AtomicInteger(0);
	private final AtomicInteger lowWriteInteger = new AtomicInteger(0);
	private final AtomicInteger highWriteInteger = new AtomicInteger(0);
	private static final int readThread = 16;
	private static final int writeThread = 128;

	private final long HIGH_MASK = 0xFFFFFFFF00000000L;

	private final long LOW_MASK = 0x00000000FFFFFFFFL;
	private final long HIGH_FACTOR = 0x100000000L;
	private long lowIncrement = 1;
	private long highIncrement = 1;
	private AtomicLong executeTimes = new AtomicLong(0L);
	private final CountDownLatch prepareSignal = new CountDownLatch(readThread
			+ writeThread * 2);
	private final CountDownLatch startSignal = new CountDownLatch(1);
	private final CountDownLatch doneSignal = new CountDownLatch(readThread
			+ writeThread * 2);
	/**
	 * 用于测试的值
	 */
	private volatile long value = 0;
	/**
	 * 运行标记
	 */
	private volatile boolean running = true;

	private long generateHighBytesLong() {
		return (HIGH_FACTOR * highIncrement++) & HIGH_MASK;
	}

	private long generateLowBytesLong() {
		return LOW_MASK & lowIncrement++;
	}

	public ValueReader createValueReader() {
		return new ValueReader();
	}

	public LowBytesValueWriter createLowBytesValueWriter() {
		return new LowBytesValueWriter();
	}

	public HighBytesValueWriter createHighBytesValueWriter() {
		return new HighBytesValueWriter();
	}

	@SuppressWarnings("unused")
	private static void executeNumberGeneraterTest() {
		VolatileLongTest test = new VolatileLongTest();
		for (int i = 0; i < 100; i++)
			System.out
					.println(Long.toHexString(test.generateHighBytesLong() >> 32));
		for (int i = 0; i < 100; i++)
			System.out.println(Long.toHexString(test.generateLowBytesLong()));
	}

	private static void executeTest() {
		VolatileLongTest test = new VolatileLongTest();
		TaskRunner runner = new TaskRunner(readThread + writeThread * 2);
		try {
			Runnable reader = test.createValueReader();
			for (int i = 0; i < readThread; i++) {
				runner.execute(reader);
			}
			Runnable lowWriter = test.createLowBytesValueWriter();
			for (int i = 0; i < writeThread; i++) {
				runner.execute(lowWriter);
			}
			Runnable highWriter = test.createHighBytesValueWriter();
			for (int i = 0; i < writeThread; i++) {
				runner.execute(highWriter);
			}
			runner.execute(highWriter);

			try {
				test.prepareSignal.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("start...");
			test.startSignal.countDown();

			try {
				test.doneSignal.await();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			runner.dispose();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 测试获取高位字节函数
		executeTest();
		System.gc();
	}

	/**
	 * 读取长整形的值
	 * 
	 * @author LiuJian
	 *
	 */
	class ValueReader implements Runnable {

		@Override
		public void run() {
			int threadNum = readThreadNum.incrementAndGet();
			long readTimes = 0;
			long copyValue = value;
			try {
				try {
					System.out.println("ReadThread:" + threadNum + ",threadId:"
							+ Thread.currentThread().getId() + " is ready...");
					prepareSignal.countDown();
					startSignal.await();
					System.out.println("ReadThread:" + threadNum
							+ "ReadThread:" + Thread.currentThread().getId()
							+ " is running...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 循环遍历,查找是否存在非原子读写的情况
				while (readTimes < 1024 * 1024 * 1024 * 128
						|| (copyValue & HIGH_MASK) == 0
						|| (copyValue & LOW_MASK) == 0) {
					readTimes++;

					if ((readTimes % (1024 * 1024 * 128)) == 0
							&& readTimes != 0) {
						System.out.println("read:"
								+ Long.toHexString(copyValue));
					}
					copyValue = value;
				}
			} finally {
				running = false;
				doneSignal.countDown();
				System.out
						.println("ReadThread:" + threadNum + "ReadThread:"
								+ Thread.currentThread().getId()
								+ " is outof going...");
			}
			System.out.println("read:" + readTimes
					+ ",  execute approximately: " + executeTimes
					+ " times : result value: " + copyValue + ", high: "
					+ Long.toHexString((copyValue & HIGH_MASK) >>> 32)
					+ ", low: " + Long.toHexString((copyValue & LOW_MASK)));

		}
	}

	/**
	 * 读取长整形的值
	 * 
	 * @author LiuJian
	 *
	 */
	class LowBytesValueWriter implements Runnable {
		int lowWriteNum = lowWriteInteger.incrementAndGet();

		@Override
		public void run() {
			try {
				try {

					System.out.println("LowWriter: " + lowWriteNum
							+ " WriteThread:" + Thread.currentThread().getId()
							+ " is ready...");
					prepareSignal.countDown();
					startSignal.await();
					System.out.println("LowWriter: " + lowWriteNum
							+ "WriteThread:" + Thread.currentThread().getId()
							+ " is running...");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int i;
				while (running) {
					for (i = 0; i < 1024 * 1024; i++) {
						executeTimes.incrementAndGet();
						value = generateLowBytesLong();

					}
				}
			} finally {
				doneSignal.countDown();
				System.out
						.println("LowWriter: " + lowWriteNum + "WriteThread:"
								+ Thread.currentThread().getId()
								+ " is outof going...");
			}
		}
	}

	/**
	 * 读取长整形的值
	 * 
	 * @author LiuJian
	 *
	 */
	class HighBytesValueWriter implements Runnable {

		@Override
		public void run() {
			int highWriteNum = highWriteInteger.incrementAndGet();
			try {
				try {
					System.out.println("HighWriter: " + highWriteNum
							+ "WriteThread:" + Thread.currentThread().getId()
							+ " is ready...");
					prepareSignal.countDown();
					startSignal.await();
					System.out.println("HighWriter: " + highWriteNum
							+ "WriteThread:" + Thread.currentThread().getId()
							+ " is running...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int i;
				while (running) {
					for (i = 0; i < 1024 * 1024; i++) {
						executeTimes.incrementAndGet();
						value = generateHighBytesLong();
					}
				}
			} finally {
				doneSignal.countDown();
				System.out.println("HighWriter: " + highWriteNum
						+ "WriteThread:" + Thread.currentThread().getId()
						+ " is outof going...");
			}
		}
	}
}
