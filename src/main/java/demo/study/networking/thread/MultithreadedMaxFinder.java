package demo.study.networking.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMaxFinder {
	public static int max(int[] data) throws InterruptedException,
			ExecutionException {
		if (data.length == 1) {
			return data[0];
		} else if (data.length == 0) {
			throw new IllegalArgumentException();
		}
		// split the job into 2 pieces
		FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
		FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);
		// spawn 2 threads
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		return Math.max(future1.get(), future2.get());
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		for (int i = 0; i < 10; i++) {
			data[i] = (int) (Math.random() * 1000 * 1000 * 1000);
			System.out.println(data[i]);
		}
		System.out.println();
		int res;
		try {
			res = max(data);
			System.out.println(res);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
