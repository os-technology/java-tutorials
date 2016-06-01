/**
 * 
 */
package cn.aposoft.design.patterns.demos.effective.nullObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author LiuJian
 *
 */
public class EmptyArrayFactoryTest {

	@Test
	public void testGenerateEmptyArray() {
		Integer[] ia = EmptyArrayFactory.array(Integer.class);
		Integer[] ia1 = EmptyArrayFactory.array(Integer.class);
		assertNotNull(ia);
		assertEquals(ia.getClass(), (new Integer[0].getClass()));
		assertEquals((Object) ia, (Object) ia1);
	}

	@Test
	public void testSpeed() {
		Integer[] ia = null;
		int count;
		int length = -1;

		ArrayGenerator generator = new SimpleArrayGenerator();
		count = 0;

		// begin new method
		long newBegin = System.currentTimeMillis();

		for (; count < 1000 * 1000 * 1000; count++) {
			ia = generator.newArray();
			length = ia.length;

		}

		long newEnd = System.currentTimeMillis();
		long newDuration = newEnd - newBegin;
		System.err.println("new:" + newDuration + "," + length);

		// 测试单例模式效率
		count = 0;

		ArrayGenerator singleGenerator = new SingletonArrayFactory();
		// begin single method
		long singleBegin = System.currentTimeMillis();

		for (; count < 1000 * 1000 * 1000; count++) {
			ia = singleGenerator.newArray();
			length = ia.length;
		}
		long singleEnd = System.currentTimeMillis();
		long singleDuration = singleEnd - singleBegin;
		System.err.println("lazy single:" + singleDuration + "," + length);

		// hungry single mode
		count = 0;

		ArrayGenerator hungryGenerator = new HungerArrayFactory();
		// begin single method
		long hungryBegin = System.currentTimeMillis();

		for (; count < 1000 * 1000 * 1000; count++) {
			ia = hungryGenerator.newArray();
			length = ia.length;
		}
		long hungryEnd = System.currentTimeMillis();
		long hungryDuration = hungryEnd - hungryBegin;
		System.err.println("hunger single:" + hungryDuration + "," + length);

		// hungry single mode
		count = 0;

		ArrayGenerator mapGenerator = new MapArrayFactory();
		// begin single method
		long mapBegin = System.currentTimeMillis();

		for (; count < 1000 * 1000 * 1000; count++) {
			ia = mapGenerator.newArray();
			length = ia.length;
		}
		long mapEnd = System.currentTimeMillis();
		long mapDuration = mapEnd - mapBegin;
		System.err.println("map integer key:" + mapDuration + "," + length);

		// begin factory method
		Class<Integer> c = Integer.class;
		count = 0;
		long factoryBegin = System.currentTimeMillis();
		for (; count < 1000 * 1000 * 1000; count++) {
			ia = EmptyArrayFactory.array(c);
			length = ia.length;
		}
		long factoryEnd = System.currentTimeMillis();
		long factoryDuration = factoryEnd - factoryBegin;
		System.err.println("map class key:" + factoryDuration + "," + length);
		long diff = factoryDuration - newDuration;
		System.err.println(diff);
		// 此例证明 通过class的hashMap获取的效果是严重降低效率的,class.equals会降低效率
		assertTrue(diff > 0);

	}

	@Test
	public void testEmptyArrayEquals() {
		Integer[] arr = new Integer[0];
		Integer[] arr1 = new Integer[0];
		System.out.println(arr == arr1);
	}

	public static void main(String[] args) {
		EmptyArrayFactoryTest test = new EmptyArrayFactoryTest();
		test.testEmptyArrayEquals();
		test.testSpeed();
	}

}
