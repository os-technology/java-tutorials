/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJian
 *
 */
public class MapArrayFactory implements ArrayGenerator {
	private static final Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
	private static final Integer KEY;
	static {
		KEY = new Integer(0);
		map.put(KEY, new Integer[0]);
	}

	@Override
	public Integer[] newArray() {
		return map.get(KEY);
	}

}
