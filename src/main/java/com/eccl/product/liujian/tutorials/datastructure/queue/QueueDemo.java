/**
 * 
 */
package com.eccl.product.liujian.tutorials.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiuJian
 *
 */
public class QueueDemo {

	private static class Sequence {
		String name;
		int value;
		int increment;

		public void setName(String name) {
			this.name = name;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void setIncrement(int increment) {
			this.increment = increment;
		}

		public static Sequence defaultInstance() {
			Sequence sequence = new Sequence();
			sequence.setName("sequence");
			sequence.setValue(1000);
			sequence.setIncrement(1);
			return sequence;
		}

		@Override
		public String toString() {
			return this.name + ":" + this.value + "," + this.increment;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createQueue();
	}

	public static void createQueue() {
		Queue<Sequence> queue;
		queue = new LinkedList<Sequence>();
		System.out.println(queue.offer(Sequence.defaultInstance()));
		System.out.println(queue.add(Sequence.defaultInstance()));
		System.out.println(queue.element());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.remove());
	}

}
