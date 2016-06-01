/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author LiuJian
 *
 */
public class DinerMenuIterator implements Iterator<MenuItem> {

	MenuItem[] items;
	int position = 0;

	public DinerMenuIterator(ArrayList<MenuItem> arrayList) {
		/*
		 * 
		 * 这里必须传入一个MenuItem[]实例的原因是,ArrayList本质上是以Object[]array
		 * 作为底层存储实现的,而在默认的Arrays.copy方法下,无法强制Cast成为其他的type类型,会出现caseException.
		 * 
		 */
		this.items = (MenuItem[]) arrayList.toArray(new MenuItem[arrayList.size()]);
	}

	public DinerMenuIterator(MenuItem[] menuItems) {
		this.items = Arrays.copyOf(menuItems, menuItems.length);
	}

	public MenuItem next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @see java.util.Iterator#remove()
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
