/**
 * 
 */
package cn.aposoft.design.patterns.demos.headfirst.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author LiuJian
 *
 */
public class EnumerationIterator<T> implements Iterator<T> {

	private Enumeration<T> enum1;

	public EnumerationIterator(Enumeration<T> enum1) {
		this.enum1 = enum1;
	}

	@Override
	public boolean hasNext() {
		enum1.hasMoreElements();
		return false;
	}

	@Override
	public T next() {
		return enum1.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
