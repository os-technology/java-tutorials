/**
 * 
 */
package com.eccl.product.liujian.tutorials.regex.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiuJian
 * 
 */
public class DigitExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String expression = "^[+-]?([1-9][0-9]*|0)(\\.[0-9]*)?$";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher("-1.16");

		System.out.println(matcher.matches());

	}
}
