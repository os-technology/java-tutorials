/**
 * 
 */
package cn.aposoft.design.patterns.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.aposoft.design.patterns.demos.ak47.com.bankht.singleton.EagerSingleton;
import cn.aposoft.design.patterns.demos.ak47.com.bankht.singleton.Singleton;

/**
 * 
 * @author LiuJian
 * @version 1.0
 */
public class EagerSingletonTest {

	@Test
	public void testSingleton() {
		Singleton ins = EagerSingleton.getInstance();
		Singleton ins1 = EagerSingleton.getInstance();
		assertEquals(ins, ins1);
	}

}
