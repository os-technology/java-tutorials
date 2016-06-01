/**
 * 
 */
package cn.aposoft.basic.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jann Liu
 *
 */
public class MatherGroupsDemo {
	private static final String COMMON_SINGLE_DOLLAR_PATTERN_TEXT = "^[_a-z]+_(\\d+)$";
	private static final String COMMON_DOUBLE_DOLLAR_PATTERN_TEXT = "^[_a-z]+_(\\d+)_(\\d+)$";

	private static final Pattern COMMON_SINGLE_DOLLAR_PATTERN = Pattern.compile(COMMON_SINGLE_DOLLAR_PATTERN_TEXT);
	private static final Pattern COMMON_DOUBLE_DOLLAR_PATTERN = Pattern.compile(COMMON_DOUBLE_DOLLAR_PATTERN_TEXT);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String singleTestText = "coupon_refund_batch_id_21";

		String doubleTestText = "coupon_refund_batch_id_11_12";

		Matcher matcher = COMMON_DOUBLE_DOLLAR_PATTERN.matcher(doubleTestText);

		if (matcher.matches()) {
			for (int i = 0; i < matcher.groupCount() + 1; i++) {
				System.out.println(matcher.group(i));
			}
			System.out.println(Integer.parseInt(matcher.group(1)));
		}

		Matcher singleMatcher = COMMON_SINGLE_DOLLAR_PATTERN.matcher(singleTestText);
		if (singleMatcher.matches()) {
			for (int i = 0; i < singleMatcher.groupCount() + 1; i++) {
				System.out.println(singleMatcher.group(i));
			}
			System.out.println(Integer.parseInt(singleMatcher.group(1)));
		}
	}
}
