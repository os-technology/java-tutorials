/**
 * 
 */
package cn.aposoft.basic.generics;

/**
 * @author LiuJian
 *
 */
public class Box<T> {
	private T t;

	public void set(T v) {
		this.t = v;
	}

	public T get() {
		return t;
	}

}
