package com.oracle.java.tutorials.reflection.arrays.troubleshoot;

import java.lang.reflect.Array;

public class ArrayTroubleToo {
	public static void main(String... args) {
		Object o = new int[3];
		Array.setShort(o, 0, (short) 2); // widening, succeeds
		Array.setInt(o, 1, 2); // just fix
		Array.setLong(o, 2, 3); // narrowing, fails
	}
}
