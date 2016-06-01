/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author LiuJian
 *
 */
public class CafeMenu implements Menu {
	Map<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

	public CafeMenu() {
		// constructor code here
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}

	public Iterator<MenuItem> iterator() {
		return menuItems.values().iterator();
	}
}
