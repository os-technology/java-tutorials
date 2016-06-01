/**
 * 
 */
package cn.aposoft.basic.encoding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Jann Liu
 *
 */
public class EncodingDemo {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String text = "于津水";
		System.out.println(text);
		char[] chars = text.toCharArray();
		int[] ints = new int[chars.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = chars[i];
		}

		System.out.println("inner:" + Arrays.toString(ints));
		byte[] gbk = text.getBytes("GBK");
		System.out.println("GBK:" + Arrays.toString(gbk));
		byte[] utf8 = text.getBytes("UTF-8");
		System.out.println("UTF-8:" + Arrays.toString(utf8));
	}

}
