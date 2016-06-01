/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

/**
 * @author LiuJian
 *
 */
public class SingletonArrayFactory implements ArrayGenerator {

	private static class ArrayHolder {
		private static Integer[] array = new Integer[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.design.patterns.demos.effective.nullObject.ArrayGenerator#
	 * newArray()
	 */
	@Override
	public Integer[] newArray() {
		return ArrayHolder.array;
	}

}
