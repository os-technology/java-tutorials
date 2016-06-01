package cn.aposoft.basic.number;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AtomicIntegerFieldUpdaterTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AtomicIntegerFieldUpdaterTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AtomicIntegerFieldUpdaterTest.class);
	}

	/**
	 * 测试 AtomicIntegerFieldUpdater 验证结果: 对于private
	 * field是无法访问的,只能根据属性值既有的访问权限进行访问,会破坏类的封装性
	 */
	public void testAtomicIntegerFieldUpdater() {
		Person person = new Person();
		AtomicIntegerFieldUpdater<Person> updater = AtomicIntegerFieldUpdater
				.newUpdater(Person.class, "age");

		int age = updater.addAndGet(person, 10);
		assertTrue(age == 20);
		assertTrue(person.getAge() == 20);
	}

	/**
	 * 私有化测试内部类
	 * 
	 * @author LiuJian
	 *
	 */
	private class Person {
		volatile int age = 10;

		/**
		 * 返回年龄要求
		 * 
		 * @return 年龄的值
		 */
		public int getAge() {
			// assert (age >= 0);
			return age;
		}
	}

}
