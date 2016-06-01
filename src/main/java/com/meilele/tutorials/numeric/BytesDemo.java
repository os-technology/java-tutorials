package com.meilele.tutorials.numeric;

public class BytesDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long n = 0L;
		try {
			byte b1 = (byte) 0xFF;

			System.out.println(b1);
			byte b2 = (byte) 255;
			System.out.println(b2);
		} catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println(n);
	}
}
