package com.oracle.java.tutorials.reflection.arrays.troubleshoot;

import static java.lang.System.out;

import java.lang.reflect.Array;

public class ArrayTrouble {
	public static void main(String... args) {
		@SuppressWarnings("unused")
		int[] a = new int[0];

		Object o = Array.newInstance(int.class, 0);
		int[] i = (int[]) o;
		int[] j = new int[0];
		out.format("i.length = %d, j.length = %d, args.length = %d%n",
				i.length, j.length, args.length);
		Array.getInt(o, 0); // ArrayIndexOutOfBoundsException
	}
}