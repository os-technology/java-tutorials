/**
 * 
 */
package com.eccl.product.liujian.tutorials.regex;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiuJian
 * 
 */
public class NumberDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String a = "e1m2j4k68ds";
		String regex = "\\D+"; // "[^0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(a);
		System.out.println(m.replaceAll("").trim());

		regex = "^[\\+\\-]?\\d+$";
		p = Pattern.compile(regex);
		m = p.matcher("+123342");
		System.out.println(m.matches());
		m = p.matcher("-1");
		System.out.println(m.matches());

		m = p.matcher("12314");
		System.out.println(m.matches());

		m = p.matcher("1234a");
		System.out.println(m.matches());
	}
}
