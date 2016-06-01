/**
 * 
 */
package cn.aposoft.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuJian
 *
 */
public class TaskRunner {
	/**
	 * 默认启动线程数量
	 */
	private static final int THREAD_NUM = 4; // default to 4
	private static final long TIME_OUT = 60000L;
	private ExecutorService service;

	@Override
	protected void finalize() throws Throwable {
		if (service != null) {
			service.shutdownNow();
			service = null;
		}
		super.finalize();
	}

	/**
	 * 
	 */
	public TaskRunner() {
		this(THREAD_NUM);
	}

	public TaskRunner(int threadNum) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
				threadNum);
		// BlockingQueue<Runnable> queue = new
		// LinkedBlockingQueue<Runnable>(THREAD_NUM);
		service = new ThreadPoolExecutor(threadNum, threadNum, TIME_OUT,
				TimeUnit.SECONDS, queue);
	}

	public void execute(Runnable command) {
		service.execute(command);
	}

	/**
	 * 关闭线程
	 */
	public void dispose() {
		if (service != null) {
			try {
				service.shutdownNow();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
