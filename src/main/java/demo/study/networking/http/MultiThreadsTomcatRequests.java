/**
 * 
 */
package demo.study.networking.http;

import java.io.IOException;

/**
 * @author LiuJian
 *
 */
public class MultiThreadsTomcatRequests implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		TomcatRequests ins = new TomcatRequests();
		try {
			ins.doRequests();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int threadCount = 150;
//		TomcatRequests ins = new TomcatRequests();
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(new MultiThreadsTomcatRequests());
		}

		for (int i = 0; i < threadCount; i++) {
			threads[i].start();
		}

//		try {
//			ins.doRequests();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
