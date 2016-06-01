/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

/**
 * @author LiuJian
 * @version 1.0
 */
public abstract class Counter implements Runnable {

	final private Synchronizer synchronizer;

	public Counter(final Synchronizer synchronizer) {
		this.synchronizer = synchronizer;
	}

	private Synchronizer synchronizer() {
		return synchronizer;
	}

	/**
	 * 提供通知的原子操作,用于线程退出时,唤醒另一个线程
	 */
	protected void signal() {
		synchronizer().signal();

	}

	/**
	 * 提供通知另一个线程,锁自己的原子性操作
	 */
	protected void signalRunnerAndWait() {
		try {
			synchronizer().lock();
			try {
				synchronizer().signalStarted();
				synchronizer().await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			synchronizer().unlock();
		}
	}

	/**
	 * 提供通知另一个线程,锁自己的原子性操作
	 */
	protected void signalAndWait() {
		try {
			synchronizer().lock();
			synchronizer().signal();
			try {
				synchronizer().await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			synchronizer().unlock();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Enter.");
		try {
			execute();
		} finally {
			// 确保通知到下一个线程去退出
			signal();
		}
		System.out.println(Thread.currentThread().getName() + " Leave.");
	}

	protected abstract void execute();
}
