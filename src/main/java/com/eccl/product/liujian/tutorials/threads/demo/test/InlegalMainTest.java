/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuJian
 * 
 */
public abstract class InlegalMainTest {
	// Illegal modifier for the field sL; only public, protected, private,
	// static, final, transient & volatile are permitted

	// synchronized
	public long sL;

	// The abstract method method in type InlegalMainTest can only set a
	// visibility modifier, one of public or protected

	// static
	public abstract void method();

	/**
	 * must have args parameters, if else, the program will not be started by java
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test");
		@SuppressWarnings("unused")
		Set<?> set = new HashSet<Object>();
	}

}
