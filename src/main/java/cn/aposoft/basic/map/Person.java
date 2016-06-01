/**
 * 
 */
package cn.aposoft.basic.map;

/**
 * @author LiuJian
 *
 */
public class Person {
	public Person(String name) {
		this.name = name;
	}

	private String name;

	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
