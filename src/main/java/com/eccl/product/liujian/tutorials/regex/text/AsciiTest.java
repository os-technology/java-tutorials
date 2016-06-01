/**
 * 
 */
package com.eccl.product.liujian.tutorials.regex.text;

/**
 * @author LiuJian
 * 
 */
public class AsciiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf(" %s %s ", '\u5218', isAscii('\u007f'));
	}

	static boolean isAscii(int ch) {
		System.out.printf("%x\n", ch & 0xFFFFFF80);
		return ((ch & 0xFFFFFF80) == 0);
	}
}
