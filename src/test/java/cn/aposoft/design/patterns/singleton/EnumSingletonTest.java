/**
 * 
 */
package cn.aposoft.design.patterns.singleton;

import org.junit.Test;

import cn.aposoft.design.patterns.demos.ak47.com.bankht.singleton.EnumSingleton;

/**
 * @author LiuJian
 *
 */
public class EnumSingletonTest {

	@Test
	public void testSingleton() {
		EnumSingleton.INSTANCE.singletonOperation();
	}
}
