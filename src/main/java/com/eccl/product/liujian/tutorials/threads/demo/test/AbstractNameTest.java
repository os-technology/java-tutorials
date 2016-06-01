/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

/**
 * @author LiuJian
 * 
 */
abstract class AbstractNameTest { // 1 correct
	@SuppressWarnings("unused")
	private String name; // 2 warning ...

	// Illegal modifier for the field intValue; only public, protected, private,
	// static, final, transient & volatile are permitted
	// private abstract Integer intValue;

	public abstract boolean isNameCorrect(String name);// {}// 3 error
}
