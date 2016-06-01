/**
 * 
 */
package cn.aposoft.basic.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJian
 *
 */
public class HashMapDemos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person("Lily");
		Person p2 = new Person("John");
		Map<Person, String> persons = new HashMap<Person, String>();
		persons.put(p1, p1.getName());
		persons.put(p2, p2.getName());
		System.out.println(persons.get(p1));
		System.out.println(persons.get(p2));
	}
}
