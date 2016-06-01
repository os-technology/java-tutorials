/**
 * 
 */
package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy.str;

import java.util.Comparator;

/**
 * @author LiuJian
 *
 */
public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		if (str1 == null || str2 == null) {
			throw new NullPointerException("argument can not be null.");
		}
		return str1.length() - str2.length();
	}

}
