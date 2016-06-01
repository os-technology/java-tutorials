/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.templateMethod;

/**
 * @author LiuJian
 *
 */
public class Duck implements Comparable<Duck> {
	String name;
	int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return name + "weighs" + weight;
	}

	@Override
	public int compareTo(Duck otherDuck) {
		if (otherDuck == null) {
			throw new NullPointerException("otherDuck must not be null.");
		} else if (this == otherDuck) {
			return 0;
		} else {
			return this.weight - otherDuck.weight;
		}
	}

}
