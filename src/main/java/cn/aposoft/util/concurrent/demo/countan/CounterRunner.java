/**
 * 
 */
package cn.aposoft.util.concurrent.demo.countan;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuJian
 * @version 1.0
 */
public class CounterRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 声明执行线程操作的服务
		ExecutorService service = null;
		Synchronizer sync = SynchronizerFactory.newSynchronizer(1, new IntruruptSyncErrorHandler(service));
		try {
			service = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

			service.execute(new AlphaCounter(sync));
			try {
				sync.awaitStarted();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			service.execute(new NumberCounter(sync));
		} finally {
			service.shutdown();
		}
	}

	private static class IntruruptSyncErrorHandler implements SyncErrorHandler {
		private ExecutorService service;

		public IntruruptSyncErrorHandler(ExecutorService service) {
			this.service = service;
		}

		@Override
		public void onError(Throwable e) {
			List<Runnable> runners = service.shutdownNow();
			System.err.println("when error occurs: there are " + runners.size() + " runners is still working.");
		}
	}
}
