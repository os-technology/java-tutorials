/**
 * 
 */
package cn.aposoft.basic.generics.effective.item26.raw;

import java.util.Arrays;

/**
 * Object-based collection - a prime candidate for generics
 * 
 * @author LiuJian
 *
 */
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPCITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPCITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
