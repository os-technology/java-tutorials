/**
 * 
 */
package cn.aposoft.util.concurrent.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Barrier Demo
 * 
 * @author Jann Liu
 *
 */
class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;
	final AtomicInteger i;

	private void processRow(int myRow) {
		System.out.println("processRow:" + myRow);
		i.decrementAndGet();
	}

	private void mergeRows() {
		System.out.println("mergeRows.");
	}

	private boolean done() {
		return i.get() == 0;
	}

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			while (!done()) {
				processRow(myRow);
				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
				System.out.println("processing is done.");
			}
		}
	}

	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		i = new AtomicInteger(N);
		Runnable barrierAction = new Runnable() {
			public void run() {
				mergeRows();
			}
		};
		barrier = new CyclicBarrier(N, barrierAction);

		List<Thread> threads = new ArrayList<Thread>(N);
		for (int i = 0; i < N; i++) {
			Thread thread = new Thread(new Worker(i));
			threads.add(thread);
			thread.start();
		}

		// wait until done
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		float[][] values = new float[10][1];
		Solver solver = new Solver(values);
		while (!solver.done()) {
			System.out.println("solving:");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
