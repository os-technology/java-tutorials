/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.iterator;

/**
 * @author LiuJian
 *
 */
public interface Menu extends Iterable<MenuItem> {
	void addItem(String name, String description, boolean vegetarian, double price);
}
