package com.eccl.product.liujian.tutorials.prime;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GeneratePrimesTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public GeneratePrimesTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(GeneratePrimesTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testGeneratePrimes() {
		int[] nullArray = GeneratePrimes.generatePrimeNumbers(0);
		assertEquals(nullArray.length, 0);

		int[] minArray = GeneratePrimes.generatePrimeNumbers(2);
		assertEquals(minArray.length, 1);
		if (minArray.length == 1) {
			assertEquals(minArray[0], 2);
		}

		int[] threeArray = GeneratePrimes.generatePrimeNumbers(3);
		assertEquals(threeArray.length, 2);
		if (threeArray.length == 2) {
			assertEquals(threeArray[0], 2);
			assertEquals(threeArray[1], 3);
		}

		int[] centArray = GeneratePrimes.generatePrimeNumbers(100);
		assertEquals(centArray.length, 25);
		if (centArray.length == 25) {
			assertEquals(centArray[24], 97);
		}

	}
}
