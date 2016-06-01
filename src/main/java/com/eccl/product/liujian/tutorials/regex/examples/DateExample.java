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
public class DateExample {

	private final static String TIME_FORMAT_24 = "([012][0-3]|[01][4-9]):[0-5][0-9]";
	private final static String timeText = "00:24 01:00 02:06 12:33 23:59 24:00";
	@SuppressWarnings("unused")
	private final static String replacement = "time ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(TIME_FORMAT_24);
		Matcher matcher = pattern.matcher(timeText);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			sb.append(timeText.substring(matcher.start(), matcher.end()));
			sb.append('\u0020');
		}
		matcher.appendTail(sb);
		System.out.println(sb.toString());
	}
}
