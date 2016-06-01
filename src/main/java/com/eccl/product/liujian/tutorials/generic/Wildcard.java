/**
 * 
 */
package com.eccl.product.liujian.tutorials.generic;

import java.util.List;

/**
 * @author LiuJian
 * 
 */
public class Wildcard {

	void foo(List<? extends Object> i) {
		assert(i != null);
		// The method set(int, capture#2-of ?) in the type List<capture#2-of ?>
		// is not applicable for the arguments (int, Object)
		// i.set(0);
		// The method set(int, capture#1-of ?) in the type List<capture#1-of ?>
		// is not applicable for the arguments (int, capture#2-of ?)
		// i.set(0, i.get(0));
	}
}
