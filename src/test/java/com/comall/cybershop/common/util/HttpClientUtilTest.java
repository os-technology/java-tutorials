/**
 * 
 */
package com.comall.cybershop.common.util;

import com.eccl.product.liujian.tuitorials.AppTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author LiuJian
 *
 */
public class HttpClientUtilTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public HttpClientUtilTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testHttpClientUtil() {
		System.out.println("in test");
		assertTrue(true);
	}

}
