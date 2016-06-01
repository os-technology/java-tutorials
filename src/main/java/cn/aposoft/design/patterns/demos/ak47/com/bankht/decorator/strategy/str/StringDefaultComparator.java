package cn.aposoft.design.patterns.demos.ak47.com.bankht.decorator.strategy.str;

import java.util.Comparator;

public class StringDefaultComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1 != null) {
			return o1.compareTo(o2);
		} else if (o2 != null) {
			return o2.compareTo(o1);
		} else {
			return 0;
		}
	}
}
