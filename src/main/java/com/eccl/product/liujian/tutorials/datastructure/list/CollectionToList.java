/**
 * 
 */
package com.eccl.product.liujian.tutorials.datastructure.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author LiuJian
 * @version 2.2.0
 */
public class CollectionToList {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<?> c = new ArrayList<Object>();
		List<?> l = new ArrayList<Object>(c);
		Comparator<Object> com = new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {

				return 0;
			}

		};
		Collections.sort(l, com);
	}
}
