/*
 * Array 在reflect运行时赋值时,无法自动执行 box unbox操作(该操作由编译器执行) 因此,对Integer类型执行setInt会发生运行时错误
 */
package com.oracle.java.tutorials.reflection.arrays.troubleshoot;

import java.lang.reflect.Array;
import static java.lang.System.err;

public class ArrayTroubleAgain {
	public static void main(String... args) {
		Integer[] ary = new Integer[2];
		try {
			Array.set(ary, 1, 1); // legal
			Array.setInt(ary, 0, 1); // IllegalArgumentException
			// production code should handle these exceptions more gracefully
		} catch (IllegalArgumentException x) {
			x.printStackTrace();
			err.format("Unable to box%n");

		} catch (ArrayIndexOutOfBoundsException x) {
			x.printStackTrace();
		}
	}
}
