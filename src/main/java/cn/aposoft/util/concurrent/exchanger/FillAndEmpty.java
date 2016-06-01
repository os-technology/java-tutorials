/**
 * 
 */
package cn.aposoft.util.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Jann Liu
 *
 */
class FillAndEmpty {
	Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
	DataBuffer initialEmptyBuffer = new DataBuffer(100);
	DataBuffer initialFullBuffer = new DataBuffer(100, 100);;

	class FillingLoop implements Runnable {
		public void run() {

			DataBuffer currentBuffer = initialEmptyBuffer;
			try {
				while (currentBuffer != null) {
					addToBuffer(currentBuffer);
					if (currentBuffer.isFull()) {
						System.out.println(Thread.currentThread().getId() + ",before exchage:" + currentBuffer.current);
						currentBuffer = exchanger.exchange(currentBuffer);
						System.out.println(Thread.currentThread().getId() + ",after exchange:" + currentBuffer.current);
						Thread.sleep(1000 * 10);
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		private void addToBuffer(DataBuffer currentBuffer) {
			currentBuffer.increment();
		}

	}

	class EmptyingLoop implements Runnable {
		public void run() {
			DataBuffer currentBuffer = initialFullBuffer;
			try {
				while (currentBuffer != null) {
					takeFromBuffer(currentBuffer);
					if (currentBuffer.isEmpty()) {
						System.out.println(Thread.currentThread().getId() + ",before exchage:" + currentBuffer.current);
						currentBuffer = exchanger.exchange(currentBuffer);
						System.out.println(Thread.currentThread().getId() + ",after exchange:" + currentBuffer.current);
						Thread.sleep(1000 * 10);
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		private void takeFromBuffer(DataBuffer currentBuffer) {
			currentBuffer.decrement();
		}
	}

	void start() {
		new Thread(new FillingLoop()).start();
		new Thread(new EmptyingLoop()).start();
	}

	private class DataBuffer {
		private int size;
		private int current = 0;

		public DataBuffer(int size, int init) {
			this.size = size;
			this.current = init;
		}

		public DataBuffer(int size) {
			this.size = size;
		}

		private void increment() {
			if (current < size) {
				current++;
			}
		}

		private void decrement() {
			if (this.current > 0) {
				this.current--;
			}
		}

		public boolean isFull() {
			return current == size;
		}

		public boolean isEmpty() {
			return current == 0;
		}
	}

	public static void main(String[] args) {
		new FillAndEmpty().start();
	}
}