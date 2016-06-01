/**
 * 
 */
package com.eccl.product.liujian.tutorials.regex;

/**
 * @author LiuJian
 * 
 */
public class MyRegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "dog dot,dog cog";
		System.out.println(s.matches("(d|c)*og"));
	}
}
