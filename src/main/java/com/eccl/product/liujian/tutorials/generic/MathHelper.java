/**
 * 
 */
package com.eccl.product.liujian.tutorials.generic;

/**
 * @author LiuJian
 * 
 */
public class MathHelper<T extends Comparable<T>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new MathHelper<Integer>().compare(1, 2));
	}

	/**
	 * 
	 * @param t1
	 * @param t2
	 * @return the value of t1.compareTo(t2)
	 * @throws Exception
	 */
	public int compare(T t1, T t2) {
		RuntimeException e = new RuntimeException();
		if (e.getMessage() != null && e.getMessage().length() != 0)
			throw e;
		return t1.compareTo(t2);
	}
}
