/**
 * 
 */
package com.eccl.product.liujian.tutorials.platform;

/**
 * @author LiuJian
 * 
 */
public class SwitchDemo {

	static public void main(String[] args) {
		// boolean b = true;
		//// Cannot switch on a value of type boolean. Only convertible int
		//// values, strings or enum variables are permitted
		// switch (b) {
		// default:
		// break;
		// }
		byte by = 10;
		switch (by) {
		default:
			break;
		}
		char c = '\70';
		switch (c) {
		case '\10':
			System.out.println(c);
			break;
		default:
			break;
		}

		short sh = 100;
		switch (sh) {
		default:
			break;
		}

		int inte = 100;
		switch (inte) {
		default:
			break;
		}
		// long l = 100;
		// // Cannot switch on a value of type long. Only convertible int
		// values,
		// // strings or enum variables are permitted
		// switch (l) {
		// default:
		// break;
		// }
	}
}
