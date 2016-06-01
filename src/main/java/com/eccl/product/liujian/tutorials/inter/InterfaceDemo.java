/**
 * 
 */
package com.eccl.product.liujian.tutorials.inter;

import java.io.Serializable;

/**
 * @author LiuJian
 * 
 */
public interface InterfaceDemo extends Serializable {
	int a = 0;
	final int b = 1;

	void run();

	public void get();
}
