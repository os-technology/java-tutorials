/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuJian
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> sl = new ArrayList<String>();
		sl.add("Yujinshui");
		sl.add("Gaojunlong");
		sl.add("Liujian");

		Collections.sort(sl, new StringDefaultComparator());
		System.out.println(Arrays.toString(sl.toArray()));
		Collections.sort(sl, new StringLengthComparator());
		System.out.println(Arrays.toString(sl.toArray()));
	}

}
