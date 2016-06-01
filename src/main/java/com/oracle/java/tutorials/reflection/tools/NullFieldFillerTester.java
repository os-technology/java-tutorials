/**
 * 
 */
package com.oracle.java.tutorials.reflection.tools;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LiuJian
 * 
 */
public class NullFieldFillerTester {

	/**
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, InstantiationException {
		Book book = new Book();

		NullFieldFiller.fillNull(book);

		if (book.getIsbn() == null || book.getName() == null) {
			System.out.println("fill error");
		} else {
			System.out.println("fill success");
		}
		System.out.println(book.getIsbn() + ":" + book.getName());
	}

}
