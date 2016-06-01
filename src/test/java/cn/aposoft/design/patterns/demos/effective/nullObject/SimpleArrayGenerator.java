/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

/**
 * @author LiuJian
 *
 */
public class SimpleArrayGenerator implements ArrayGenerator {

	@Override
	public Integer[] newArray() {
		return new Integer[0];
	}
}
