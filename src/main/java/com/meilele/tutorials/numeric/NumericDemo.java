/**
 * 
 */
package com.meilele.tutorials.numeric;

/**
 * @author LiuJian
 * 
 */
public class NumericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long n = 0L;
		try {
			//java.lang.NumberFormatException: For input string: ""
			// at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
			// at java.lang.Long.parseLong(Long.java:453)
			// at java.lang.Long.valueOf(Long.java:540)
			// at com.meilele.tutorials.numeric.NumericDemo.main(NumericDemo.java:18)
			n = Long.valueOf("");
		} catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
		}
		
		System.out.println(n);
	}

}
