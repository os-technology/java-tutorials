/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

/**
 * @author LiuJian
 *
 */
public class HungerArrayFactory implements ArrayGenerator {
	private static Integer[] array = new Integer[0];

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.design.patterns.demos.effective.nullObject.ArrayGenerator#
	 * newArray()
	 */
	@Override
	public Integer[] newArray() {
		return array;
	}
}
