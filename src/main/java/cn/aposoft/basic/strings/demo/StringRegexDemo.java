/**
 * 
 */
package cn.aposoft.basic.strings.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jann Liu
 *
 */
public class StringRegexDemo {

	private static final String contentText = "`2015-10-28 14:34:34,`123,`123,`0,`,`123,`128,`128,`NATIVE,`SUCCESS,`CFT,`CNY,`0.17,`0.00,`0,`0,`0,`0,`,`,`Hermes Perfume,`,`0.00000,`0.80%";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		regexSplit();
	}

	/**
	 * 
	 */
	private static void regexSplit() {
		String[] result = contentText.split("(^`|,`)");
		List<String> listResult = Arrays.asList(result);
		System.out.println("array length:" + result.length + ",content:" + Arrays.toString(result));
		System.out.println("list size:" + listResult.size() + ",content:" + listResult);
	}
}
