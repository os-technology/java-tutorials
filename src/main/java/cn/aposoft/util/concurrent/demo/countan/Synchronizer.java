/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

/**
 * @author LiuJian
 * @version 1.0
 */
public interface Synchronizer {
	/**
	 * 提供同步锁加锁
	 * 
	 * @return 多线程同步用的Lock
	 */
	void lock();

	/**
	 * 提供同步锁,解锁
	 * 
	 * @return 多线程同步用的Lock
	 */
	void unlock();

	/**
	 * 执行等待启动的条件
	 * 
	 * @return {@link CountDownLatch}
	 */
	void signalStarted();

	/**
	 * 等待启动 , 与主线程同步
	 * 
	 * @throws InterruptedException
	 */
	void awaitStarted() throws InterruptedException;

	void await() throws InterruptedException;

	void signal();

	void signalAll();

	void error(Throwable e);
}
