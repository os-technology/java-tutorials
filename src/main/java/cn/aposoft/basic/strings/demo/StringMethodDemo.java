/**
 * 
 */
package cn.aposoft.basic.strings.demo;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jann Liu
 *
 */
public class StringMethodDemo {
	private static final String COUPON_BATCH_ID = "coupon_batch_id_$";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		testReplace();
		// copyOfRange();
	}

	static void couponTypeMathch() {
		String id = "coupon_batch_id_$1";
		System.out.println(id.substring(COUPON_BATCH_ID.length()));
		int n = Integer.parseInt(id.substring(COUPON_BATCH_ID.length()));
		System.out.println(n);
	}

	static void copyOfRange() {
		String[] arr = { "0", "1", "2", "3", "4", "5", "6" };// new String [];
		String[] result = Arrays.copyOfRange(arr, 1, arr.length);
		System.out.println(Arrays.toString(result));
	}

	static void testReplace() {
		String patternFormat = ",\"sign\":\"(3f96ff348afb03b2b4c6a5611f958dd9)\"}$";
		String origin = "{\"body\":{\"age\":21,\"name\":\"张津南\"},\"sign\":\"3f96ff348afb03b2b4c6a5611f958dd9\"}";
		String dest = origin.replaceFirst(patternFormat, ",\"sign\":\"key1111\"}");
		Pattern pattern = Pattern.compile(patternFormat);
		Matcher matcher = pattern.matcher(origin);
		matcher.matches();
		String regexDest = matcher.replaceFirst(",\"sign\":\"key1111\"}");
		if (matcher.groupCount() == 1) {

		}
		System.out.println(dest);
		System.out.println(regexDest);
	}
}
